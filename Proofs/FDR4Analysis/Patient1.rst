interface TasksStartI {
	DisplayCleaningPlanStart()
	SilentFloorCleaningStart()
	AssessRoomStart()
	DustFurnitureStart()
	NotifyPatientStart()
	CleanFloorStart()
}
interface TasksEndI {
	event DisplayCleaningPlanEnd
	event SilentFloorCleaningEnd
	event AssessRoomEnd
	event DustFurnitureEnd
	event NotifyPatientEnd
	event CleanFloorEnd
}
interface GuardsI {
	event floorNeedsCleaning : boolean
	event personResting : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			input context { uses TasksEndI uses GuardsI }
			output context { requires TasksStartI }
			cycleDef true
			initial s0
			transition t0 {
				from s0
				to s1
			}
			final s2
			state s1 {
				entry $ NotifyPatientStart() ; exec
			}
			transition t1 {
				from s1
				to s4
				exec
				condition $NotifyPatientEnd
			}
			transition t2 {
				from s1
				to s1
				exec
				condition not $NotifyPatientEnd
			}
			state s4 {
				entry $ AssessRoomStart() ; exec
			}
			transition t3 {
				from s4
				to s5
				exec
				condition $AssessRoomEnd
			}
			transition t4 {
				from s4
				to s4
				exec
				condition not $AssessRoomEnd
			}
			state s5 {
				entry $ DisplayCleaningPlanStart() ; exec
			}
			transition t5 {
				from s5
				to s6
				exec
				condition $DisplayCleaningPlanEnd
			}
			transition t6 {
				from s5
				to s5
				exec
				condition not $DisplayCleaningPlanEnd
			}
			state s6 {
				entry $ DustFurnitureStart() ; exec
			}
			transition t7 {
				from s6
				to s7
				exec
				condition $DustFurnitureEnd
			}
			transition t8 {
				from s6
				to s6
				exec
				condition not $DustFurnitureEnd
			}
			state s7 {}
			state s8 {}
			transition t9 {
				from s8
				to s2
			}
			transition t10 {
				from s7
				to s9
				exec
				condition $floorNeedsCleaning
			}
			state s10 {}
			state s9 {}
			state s13 {}
			transition t11 {
				from s13
				to s10
			}
			transition t12 {
				from s9
				to s14
				exec
				condition $personResting
			}
			state s14 {
				entry $ SilentFloorCleaningStart() ; exec
			}
			transition t13 {
				from s14
				to s13
				exec
				condition $SilentFloorCleaningEnd
			}
			transition t14 {
				from s14
				to s14
				exec
				condition not $SilentFloorCleaningEnd
			}
			transition t15 {
				from s9
				to s13
				exec
				condition not $personResting
			}
			transition t16 {
				from s10
				to s17
			}
			state s17 {
				entry $ CleanFloorStart() ; exec
			}
			transition t17 {
				from s17
				to s8
				exec
				condition $CleanFloorEnd
			}
			transition t18 {
				from s17
				to s17
				exec
				condition not $CleanFloorEnd
			}
			transition t19 {
				from s7
				to s8
				exec
				condition not $floorNeedsCleaning
			}
		}
		connection C on DisplayCleaningPlanEnd to wfSTM on DisplayCleaningPlanEnd (_async)
		connection C on SilentFloorCleaningEnd to wfSTM on SilentFloorCleaningEnd (_async)
		connection C on AssessRoomEnd to wfSTM on AssessRoomEnd (_async)
		connection C on DustFurnitureEnd to wfSTM on DustFurnitureEnd (_async)
		connection C on NotifyPatientEnd to wfSTM on NotifyPatientEnd (_async)
		connection C on CleanFloorEnd to wfSTM on CleanFloorEnd (_async)
		connection C on floorNeedsCleaning to wfSTM on floorNeedsCleaning (_async)
		connection C on personResting to wfSTM on personResting (_async)
	}
	connection RP on DisplayCleaningPlanEnd to C on DisplayCleaningPlanEnd (_async)
	connection RP on SilentFloorCleaningEnd to C on SilentFloorCleaningEnd (_async)
	connection RP on AssessRoomEnd to C on AssessRoomEnd (_async)
	connection RP on DustFurnitureEnd to C on DustFurnitureEnd (_async)
	connection RP on NotifyPatientEnd to C on NotifyPatientEnd (_async)
	connection RP on CleanFloorEnd to C on CleanFloorEnd (_async)
	connection RP on floorNeedsCleaning to C on floorNeedsCleaning (_async)
	connection RP on personResting to C on personResting (_async)
}
