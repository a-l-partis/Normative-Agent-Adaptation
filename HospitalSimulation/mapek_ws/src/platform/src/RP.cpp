
#include <cstdio>
#include <chrono>
#include <functional>
#include <memory>
#include <string>

#include "rclcpp/rclcpp.hpp"
#include "rclcpp_action/rclcpp_action.hpp"

#include "std_msgs/msg/string.hpp"
#include "std_msgs/msg/bool.hpp"
#include "irobot_create_msgs/action/undock.hpp"
#include "irobot_create_msgs/action/dock.hpp"
#include "turtlebot4_msgs/msg/user_led.hpp"
#include "turtlebot4_msgs/msg/user_button.hpp"
#include "geometry_msgs/msg/twist.hpp"

#include "hosppatient1_interface/msg/assess_room_start.hpp"
#include "hosppatient1_interface/msg/clean_floor_start.hpp"
#include "hosppatient1_interface/msg/display_cleaning_plan_start.hpp"
#include "hosppatient1_interface/msg/dust_furniture_start.hpp"
#include "hosppatient1_interface/msg/notify_patient_start.hpp"
#include "hosppatient1_interface/msg/set_silent_floor_cleaning_start.hpp"

using namespace std::chrono_literals;
using TwistMsg = geometry_msgs::msg::Twist;

class RP: public rclcpp::Node {



  rclcpp::CallbackGroup::SharedPtr callback_group_subscribers;
  rclcpp::CallbackGroup::SharedPtr callback_group_timers;
  rclcpp::CallbackGroup::SharedPtr callback_group_clients;

  public:
    using Undock = irobot_create_msgs::action::Undock;
    using GoalHandleUndock = rclcpp_action::ClientGoalHandle<Undock>;

    using Dock = irobot_create_msgs::action::Dock;
    using GoalHandleDock = rclcpp_action::ClientGoalHandle<Dock>;

    

    RP(): Node("RP") {


      callback_group_subscribers = this->create_callback_group(rclcpp::CallbackGroupType::MutuallyExclusive);
      callback_group_timers = this->create_callback_group(rclcpp::CallbackGroupType::MutuallyExclusive);
      callback_group_clients = this->create_callback_group(rclcpp::CallbackGroupType::MutuallyExclusive);

      auto sub1_opt = rclcpp::SubscriptionOptions();
      sub1_opt.callback_group = callback_group_subscribers;

    
      // Platform inputs
      
      cmd_vel_pub = this->create_publisher<TwistMsg>("cmd_vel",rclcpp::QoS(10).reliable().transient_local());
      task_display_pub = this->create_publisher<std_msgs::msg::String>("hmi/display/message",rclcpp::QoS(10).reliable().transient_local());

      
      floorNeedsCleaning_pub = this->create_publisher<std_msgs::msg::Bool>("floorNeedsCleaning", rclcpp::QoS(10).transient_local());
      personResting_pub = this->create_publisher<std_msgs::msg::Bool>("personResting", rclcpp::QoS(10).transient_local());
      
      floorNeedsCleaningPubTimer = this->create_wall_timer(
        std::chrono::milliseconds(250),
        std::bind(&RP::floorNeedsCleaningPubCallback, this)
      );

      personRestingPubTimer = this->create_wall_timer(
        std::chrono::milliseconds(250),
        std::bind(&RP::personRestingPubCallback, this)
      );
      
      
      undock_client_ptr_ = rclcpp_action::create_client<irobot_create_msgs::action::Undock>(this,"undock", callback_group_clients);
      dock_client_ptr_ = rclcpp_action::create_client<irobot_create_msgs::action::Dock>(this,"dock", callback_group_clients);

      auto AssessRoomStart_callback = [this](hosppatient1_interface::msg::AssessRoomStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "AssessRoomStart call received by platform.");
        assessroom();
      };
      AssessRoomStart = this->create_subscription<hosppatient1_interface::msg::AssessRoomStart>("AssessRoomStart", rclcpp::QoS(10).reliable().transient_local(), AssessRoomStart_callback, sub1_opt);
      AssessRoomEnd = this->create_publisher<std_msgs::msg::Bool>("AssessRoomEnd",rclcpp::QoS(10).reliable().transient_local());

      auto DustFurnitureStart_callback = [this](hosppatient1_interface::msg::DustFurnitureStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "DustFurnitureStart call received by platform.");
        dustfurniture();
      };
      DustFurnitureStart = this->create_subscription<hosppatient1_interface::msg::DustFurnitureStart>("DustFurnitureStart", rclcpp::QoS(10).reliable().transient_local(), DustFurnitureStart_callback, sub1_opt);
      DustFurnitureEnd = this->create_publisher<std_msgs::msg::Bool>("DustFurnitureEnd",rclcpp::QoS(10).reliable().transient_local());
      
      auto CleanFloorStart_callback = [this](hosppatient1_interface::msg::CleanFloorStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "CleanFloorStart call received by platform.");
        cleanfloor();
      };
      CleanFloorStart = this->create_subscription<hosppatient1_interface::msg::CleanFloorStart>("CleanFloorStart", rclcpp::QoS(10).reliable().transient_local(), CleanFloorStart_callback, sub1_opt);
      CleanFloorEnd = this->create_publisher<std_msgs::msg::Bool>("CleanFloorEnd",rclcpp::QoS(10).reliable().transient_local());

      auto DisplayCleaningPlanStart_callback = [this](hosppatient1_interface::msg::DisplayCleaningPlanStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "DisplayCleaningPlanStart call received by platform.");
        displaycleaningplan();
      };
      DisplayCleaningPlanStart = this->create_subscription<hosppatient1_interface::msg::DisplayCleaningPlanStart>("DisplayCleaningPlanStart", rclcpp::QoS(10).reliable().transient_local(), DisplayCleaningPlanStart_callback, sub1_opt);
      DisplayCleaningPlanEnd = this->create_publisher<std_msgs::msg::Bool>("DisplayCleaningPlanEnd",rclcpp::QoS(10).reliable().transient_local());
      
      auto NotifyPatientStart_callback = [this](hosppatient1_interface::msg::NotifyPatientStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "NotifyPatientStart call received by platform.");
        notifypatient();
      };
      NotifyPatientStart = this->create_subscription<hosppatient1_interface::msg::NotifyPatientStart>("NotifyPatientStart", rclcpp::QoS(10).reliable().transient_local(), NotifyPatientStart_callback, sub1_opt);
      NotifyPatientEnd = this->create_publisher<std_msgs::msg::Bool>("NotifyPatientEnd",rclcpp::QoS(10).reliable().transient_local());
      
      auto SetSilentFloorCleaningStart_callback = [this](hosppatient1_interface::msg::SetSilentFloorCleaningStart msg) -> void {

        RCLCPP_INFO(this->get_logger(), "SetSilentFloorCleaningStart call received by platform.");
        setsilentfloorcleaning();
      };
      SetSilentFloorCleaningStart = this->create_subscription<hosppatient1_interface::msg::SetSilentFloorCleaningStart>("SetSilentFloorCleaningStart", rclcpp::QoS(10).reliable().transient_local(), SetSilentFloorCleaningStart_callback, sub1_opt);
      SetSilentFloorCleaningEnd = this->create_publisher<std_msgs::msg::Bool>("SetSilentFloorCleaningEnd",rclcpp::QoS(10).reliable().transient_local());

      LED = this->create_publisher<turtlebot4_msgs::msg::UserLed>("hmi/led",rclcpp::QoS(10).reliable().transient_local());

      auto Buttons_callback = [this](turtlebot4_msgs::msg::UserButton::UniquePtr msg) -> void {
        RCLCPP_INFO(this->get_logger(), "Button pressed.");
        if (msg->button[0]) {
          RCLCPP_INFO(this->get_logger(), "Button1.");
          floorneedscleaning(true);
        } else if (msg->button[1]) {
          RCLCPP_INFO(this->get_logger(), "Button2.");
          floorneedscleaning(false);
        } else if (msg->button[2]) {
          RCLCPP_INFO(this->get_logger(), "Button3.");
          personresting(true);
        }else if (msg->button[3]) {
          RCLCPP_INFO(this->get_logger(), "Button4.");
          personresting(false);
          }
      };
      
      buttons_subscriber_ = this->create_subscription<turtlebot4_msgs::msg::UserButton>(
        "/hmi/buttons", 
        rclcpp::QoS(rclcpp::KeepLast(10)).best_effort().durability_volatile(),
        Buttons_callback, sub1_opt
                
      );        
    }
    
    

    
    private:
    
      bool floorNeedsCleaning;
      bool personResting;
      std::string cleanFloorLEDColour = "";
    
      rclcpp::Publisher<TwistMsg>::SharedPtr cmd_vel_pub;
      rclcpp::Publisher<std_msgs::msg::String>::SharedPtr task_display_pub;
          
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr floorNeedsCleaning_pub;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr personResting_pub;
      
      rclcpp::TimerBase::SharedPtr floorNeedsCleaningPubTimer;
      rclcpp::TimerBase::SharedPtr personRestingPubTimer;
      
      // In your class constructor

      void floorNeedsCleaningPubCallback() {
        auto message = std_msgs::msg::Bool();
        message.data = this->floorNeedsCleaning;
  
        //RCLCPP_INFO(this->get_logger(), "Publishing FloorNeedsCleaning: '%s'", message.data ? "true" : "false");
  
        floorNeedsCleaning_pub->publish(message);
}
            
      void personRestingPubCallback() {
        auto message = std_msgs::msg::Bool();
        message.data = this->personResting;
  
        //RCLCPP_INFO(this->get_logger(), "Publishing PersonResting: '%s'", message.data ? "true" : "false");
  
        personResting_pub->publish(message);
}
      
      
      
      rclcpp::Publisher<turtlebot4_msgs::msg::UserLed>::SharedPtr LED;
      

      rclcpp_action::Client<irobot_create_msgs::action::Undock>::SharedPtr undock_client_ptr_;
      
      rclcpp::Subscription<hosppatient1_interface::msg::AssessRoomStart>::SharedPtr d;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr dockFinished_;

      
      bool undock_in_progress = false;
      
      //Start of docking and undocking

      
      rclcpp_action::Client<irobot_create_msgs::action::Dock>::SharedPtr dock_client_ptr_;
      

      void dock() {
        using namespace std::placeholders;
        if (!this->dock_client_ptr_->wait_for_action_server()) {
          RCLCPP_ERROR(this->get_logger(), "Dock action server not available after waiting");
          rclcpp::shutdown();
        }

        auto dock_goal_msg = irobot_create_msgs::action::Dock::Goal();
        RCLCPP_INFO(this->get_logger(), "Sending dock goal");

        auto send_dock_goal_options = rclcpp_action::Client<Dock>::SendGoalOptions();
        send_dock_goal_options.feedback_callback =
          std::bind(&RP::dock_feedback_callback, this, _1, _2);
        send_dock_goal_options.result_callback =
          std::bind(&RP::dock_result_callback, this, _1);
        this->dock_client_ptr_->async_send_goal(dock_goal_msg, send_dock_goal_options);
      }

      void dock_feedback_callback(
        GoalHandleDock::SharedPtr,
        const std::shared_ptr<const Dock::Feedback> feedback)
      {
        std::stringstream ss;

        if (feedback->sees_dock) {
          ss << "Dock is visible.";
        } else {
          ss << "Dock is not visible.";
        }
        
        RCLCPP_INFO(this->get_logger(), ss.str().c_str());
      }

      void dock_result_callback(const GoalHandleDock::WrappedResult & result)
      {
        switch (result.code) {
          case rclcpp_action::ResultCode::SUCCEEDED:
            break;
          case rclcpp_action::ResultCode::ABORTED:
            RCLCPP_ERROR(this->get_logger(), "Dock goal was aborted");
            return;
          case rclcpp_action::ResultCode::CANCELED:
            RCLCPP_ERROR(this->get_logger(), "Dock goal was canceled");
            return;
          default:
            RCLCPP_ERROR(this->get_logger(), "Unknown result code");
            return;
        }
        if (result.result->is_docked) {
          RCLCPP_INFO(this->get_logger(), "Robot successfully docked.");
        }
      }

      rclcpp::Subscription<hosppatient1_interface::msg::AssessRoomStart>::SharedPtr AssessRoomStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr AssessRoomEnd;


    

    void assessroom() {
    	using namespace std::placeholders;
      using TwistMsg = geometry_msgs::msg::Twist;
      auto task_msg = std_msgs::msg::String();
      task_msg.data = "AssessRoom";
      task_display_pub->publish(task_msg);
      
      undock();
    }

    
      void undock() {
      
        using namespace std::placeholders;
        if (undock_in_progress) {
            return;
        }
        undock_in_progress = true;
        if (!this->undock_client_ptr_->wait_for_action_server()) {
          RCLCPP_ERROR(this->get_logger(), "Undock action server not available after waiting");
          rclcpp::shutdown();
        }

        auto undock_goal_msg = irobot_create_msgs::action::Undock::Goal();
        RCLCPP_INFO(this->get_logger(), "Sending Undock goal");

        auto send_undock_goal_options = rclcpp_action::Client<Undock>::SendGoalOptions();
        send_undock_goal_options.result_callback =
          std::bind(&RP::undock_result_callback, this, _1);
          
        this->undock_client_ptr_->async_send_goal(undock_goal_msg, send_undock_goal_options);
      }

    void undock_result_callback(const GoalHandleUndock::WrappedResult & result)
      {
        undock_in_progress = false;

    if (result.code == rclcpp_action::ResultCode::SUCCEEDED) {
      // rotation
      rotate();
    } else {
        RCLCPP_ERROR(this->get_logger(), "Undock failed, cannot assess room.");
    }
  }

    rclcpp::TimerBase::SharedPtr rotateTimer;
    rclcpp::TimerBase::SharedPtr finishRotateTimer;
      
    void rotate() {
        if (!rotateTimer) {
            rotateTimer = this->create_wall_timer(
                0.3s, std::bind(&RP::rotateCallback, this));
          }
        if (!finishRotateTimer){
          finishRotateTimer = this->create_wall_timer(
                2s, std::bind(&RP::rotateFinishCallback, this));
        }
    }
    
    void rotateCallback() {
    
      using TwistMsg = geometry_msgs::msg::Twist;
        auto msg = geometry_msgs::msg::Twist();
        msg.linear.x = 0.0;
        msg.linear.y = 0.0;
        msg.linear.z = 0.0;
        msg.angular.x = 0.0;
        msg.angular.y = 0.0;
        msg.angular.z = 1.0;
        
        this->cmd_vel_pub ->publish(msg);
        }
        
      void rotateFinishCallback() {
        using TwistMsg = geometry_msgs::msg::Twist;
        TwistMsg stop;
        stop.linear.x = 0;
        stop.linear.y = 0;
        stop.linear.z = 0;

        stop.angular.x = 0;
        stop.angular.y = 0;
        stop.angular.z = 0;

        this->cmd_vel_pub->publish(stop);
        if (this->rotateTimer) {
                this->rotateTimer->cancel();
            }
            
        if (this->finishRotateTimer) {
            this->finishRotateTimer->cancel();
            }
                
        RCLCPP_INFO(this->get_logger(), "AssessRoom Done");
        auto message = std_msgs::msg::Bool();
        message.data = true;
        this->AssessRoomEnd->publish(message);
      }
      
      rclcpp::Subscription<hosppatient1_interface::msg::DustFurnitureStart>::SharedPtr DustFurnitureStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr DustFurnitureEnd;
      rclcpp::TimerBase::SharedPtr motion_timer2;
      rclcpp::TimerBase::SharedPtr finish_timer2;
      

    void dustfurniture() {
    	using namespace std::placeholders;
        using TwistMsg = geometry_msgs::msg::Twist;
          auto task_msg = std_msgs::msg::String();
          task_msg.data = "DustFurniture";
          task_display_pub->publish(task_msg);
      

        if (!this->undock_client_ptr_->wait_for_action_server()) {
          RCLCPP_ERROR(this->get_logger(), "Motion action server not available after waiting");
          rclcpp::shutdown();
        } else {

          if(!motion_timer2) {
              motion_timer2 = this->create_wall_timer(
                0.5s, std::bind(&RP::dustfurniture_timer_motion_callback, this));
           }

          if(!finish_timer2) {
              finish_timer2 = this->create_wall_timer(
              5s, std::bind(&RP::dustfurniture_timer_finish_callback, this));
          }
        }
    }
    
      void dustfurniture_timer_motion_callback() {
        using TwistMsg = geometry_msgs::msg::Twist;
        TwistMsg msg;
        msg.linear.x = 0.3;
        msg.linear.y = 0;
        msg.linear.z = 0;

        msg.angular.x = 0.3;
        msg.angular.y = 0;
        msg.angular.z = 0;
        this->cmd_vel_pub->publish(msg);
      }
      
      void dustfurniture_timer_finish_callback()
      {
        TwistMsg stop;
        stop.linear.x = 0;
        stop.linear.y = 0;
        stop.linear.z = 0;

        stop.angular.x = 0;
        stop.angular.y = 0;
        stop.angular.z = 0;

        this->cmd_vel_pub->publish(stop);
        this->motion_timer2->cancel();
        this->finish_timer2->cancel();
        
        RCLCPP_INFO(this->get_logger(), "DustFurniture Done");
        auto message = std_msgs::msg::Bool();
        message.data = true;
        this->DustFurnitureEnd->publish(message);
        
      }
      
      
      




rclcpp::Subscription<hosppatient1_interface::msg::CleanFloorStart>::SharedPtr CleanFloorStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr CleanFloorEnd;
      rclcpp::TimerBase::SharedPtr cleanFloor_motion_timer;
      rclcpp::TimerBase::SharedPtr cleanFloor_finish_timer;
      
    void cleanfloor() {
    	using namespace std::placeholders;
        using TwistMsg = geometry_msgs::msg::Twist;
        auto task_msg = std_msgs::msg::String();
        task_msg.data = "CleanFloor";
        task_display_pub->publish(task_msg);
      
        setLED(false,2,this->cleanFloorLEDColour,true);
        if (!this->undock_client_ptr_->wait_for_action_server()) {
          RCLCPP_ERROR(this->get_logger(), "Motion action server not available after waiting");
          rclcpp::shutdown();
        } else {

          if(!cleanFloor_motion_timer){
              cleanFloor_motion_timer = this->create_wall_timer(
                0.5s, std::bind(&RP::cleanFloor_motion_timer_callback, this));
          }

          if(!cleanFloor_finish_timer){
              cleanFloor_finish_timer = this->create_wall_timer(
                5s, std::bind(&RP::cleanfloor_timer_finish_callback, this));
          }
        }
    }
    
      void cleanFloor_motion_timer_callback() {
        using TwistMsg = geometry_msgs::msg::Twist;
        TwistMsg msg;
        msg.linear.x = 0.3;
        msg.linear.y = 0;
        msg.linear.z = 0;
        msg.angular.x = 0;
        msg.angular.y = 0;
        msg.angular.z = 0;

        this->cmd_vel_pub->publish(msg);
      }
      
      void cleanfloor_timer_finish_callback()
      {
	setLED(true,1,"",false);
        TwistMsg stop;
        this->cmd_vel_pub->publish(stop);
        this->cleanFloor_motion_timer->cancel();
        this->cleanFloor_finish_timer->cancel();
        
        RCLCPP_INFO(this->get_logger(), "CleanFloor Done");
        auto message = std_msgs::msg::Bool();
        message.data = true;
        this->CleanFloorEnd->publish(message);
      }


      
      
	rclcpp::Subscription<hosppatient1_interface::msg::DisplayCleaningPlanStart>::SharedPtr DisplayCleaningPlanStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr DisplayCleaningPlanEnd;
      rclcpp::TimerBase::SharedPtr displayEndTimer;
      
      void displaycleaningplan() {
          auto task_msg = std_msgs::msg::String();
          task_msg.data = "DisplayCleaningPlan";
          task_display_pub->publish(task_msg);
      
        setLED(false,2,"red",true);
        displayEndTimer = this->create_wall_timer(
          10s, std::bind(&RP::display_cleaning_plan_callback, this));
      }
      
      void display_cleaning_plan_callback() {
          this->displayEndTimer->cancel();
          setLED(true,2,"",false);
          RCLCPP_INFO(this->get_logger(), "DisplayCleaningPlan Done");
          auto message = std_msgs::msg::Bool();
          message.data = true;
          this->DisplayCleaningPlanEnd->publish(message);
      }
      
rclcpp::Subscription<hosppatient1_interface::msg::NotifyPatientStart>::SharedPtr NotifyPatientStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr NotifyPatientEnd;
      rclcpp::TimerBase::SharedPtr notifypatient_timer;
      
      void notifypatient() {
      	  // intialise guards
      	  
          auto task_msg = std_msgs::msg::String();
          task_msg.data = "NotifyPatient";
          task_display_pub->publish(task_msg);
      
          setLED(false,2,"red",true);
          if (!notifypatient_timer) {
              notifypatient_timer = this->create_wall_timer(
                10s, std::bind(&RP::notifypatient_callback, this));
          }
      }
      
      void notifypatient_callback() {
          setLED(true,2,"",false);
          RCLCPP_INFO(this->get_logger(), "NotifyPatient Done");
          auto message = std_msgs::msg::Bool();
          message.data = true;
          this->NotifyPatientEnd->publish(message);
          this->notifypatient_timer->cancel();
      }
      

	rclcpp::Subscription<hosppatient1_interface::msg::SetSilentFloorCleaningStart>::SharedPtr SetSilentFloorCleaningStart;
      rclcpp::Publisher<std_msgs::msg::Bool>::SharedPtr SetSilentFloorCleaningEnd;
      rclcpp::TimerBase::SharedPtr setsilentfloorcleaning_timer;
      
      void setsilentfloorcleaning() {
          auto task_msg = std_msgs::msg::String();
          task_msg.data = "SetSilentCleaningMode";
          task_display_pub->publish(task_msg);
      
          this->cleanFloorLEDColour = "red";
          RCLCPP_INFO(this->get_logger(), "SetSilentFloorCleaning Done");
          auto message = std_msgs::msg::Bool();
          message.data = true;
          this->SetSilentFloorCleaningEnd->publish(message);
      }      
      // measures
      rclcpp::Subscription<turtlebot4_msgs::msg::UserButton>::SharedPtr buttons_subscriber_;


      void floorneedscleaning(bool setbool) {
	this->floorNeedsCleaning = setbool;
      }

      void personresting(bool setbool) {
	this->personResting = setbool;
      }

      void setLED(bool stop, int ledNum, std::string colour,bool blink) {
          turtlebot4_msgs::msg::UserLed message;
          if(ledNum == 1) {
              message.led = (uint8_t)0;
          } else {
              //led2
              message.led = (uint8_t)1;
          }
          if(blink){
              message.blink_period = 1000;
              message.duty_cycle = 0.5;
          } else {
              message.blink_period = 0;
              message.duty_cycle = 1.0;
          }
          if (stop){
              message.color = turtlebot4_msgs::msg::UserLed::COLOR_OFF;
              message.blink_period = 0;
              message.duty_cycle = 0.0;
              //RCLCPP_INFO(this->get_logger(), "switchingLED off");
          } else if(colour=="green"){
              message.color = turtlebot4_msgs::msg::UserLed::COLOR_GREEN;
          } else if(colour=="yellow"){
              message.color = turtlebot4_msgs::msg::UserLed::COLOR_YELLOW;
          } else if (colour=="red"){
              //red
              message.color = turtlebot4_msgs::msg::UserLed::COLOR_RED;
          } else {
              message.color = turtlebot4_msgs::msg::UserLed::COLOR_OFF;
              message.blink_period = 0;
              message.duty_cycle = 0.0;
              //RCLCPP_INFO(this->get_logger(), "switchingLED off");
          }
          //Send a message when called
          LED->publish(message);
      }
      
};

int main(int argc, char ** argv)
{
  rclcpp::init(argc, argv);
  rclcpp::executors::MultiThreadedExecutor executor;
  auto node = std::make_shared<RP>();
  executor.add_node(node);
  executor.spin();

  rclcpp::shutdown();
  return 0;
}
      


