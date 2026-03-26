interface TasksStartI {
	PlaceWetFloorSignStart()
	DisplayCleaningPlanStart()
	WarnAboutWetFloorStart()
	OpenWindowStart()
	AssessRoomStart()
	DustFurnitureStart()
	CleanFloorStart()
}
interface TasksEndI {
	event PlaceWetFloorSignEnd
	event DisplayCleaningPlanEnd
	event WarnAboutWetFloorEnd
	event OpenWindowEnd
	event AssessRoomEnd
	event DustFurnitureEnd
	event CleanFloorEnd
}
interface GuardsI {
	event prayingTime : boolean
	event floorNeedsCleaning : boolean
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
				entry $ AssessRoomStart() ; exec
			}
			transition t1 {
				from s1
				to s4
				exec
				condition $AssessRoomEnd
			}
			transition t2 {
				from s1
				to s1
				exec
				condition not $AssessRoomEnd
			}
			state s4 {
				entry $ DisplayCleaningPlanStart() ; exec
			}
			transition t3 {
				from s4
				to s5
				exec
				condition $DisplayCleaningPlanEnd
			}
			transition t4 {
				from s4
				to s4
				exec
				condition not $DisplayCleaningPlanEnd
			}
			state s5 {
				entry $ OpenWindowStart() ; exec
			}
			transition t5 {
				from s5
				to s6
				exec
				condition $OpenWindowEnd
			}
			transition t6 {
				from s5
				to s5
				exec
				condition not $OpenWindowEnd
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
			state s9 {
				entry $ CleanFloorStart() ; exec
			}
			transition t11 {
				from s9
				to s10
				exec
				condition $CleanFloorEnd
			}
			transition t12 {
				from s9
				to s9
				exec
				condition not $CleanFloorEnd
			}
			state s10 {}
			state s11 {}
			transition t13 {
				from s11
				to s8
			}
			transition t14 {
				from s10
				to s12
				exec
				condition $prayingTime
			}
			state s12 {
				entry $ PlaceWetFloorSignStart() ; exec
			}
			transition t15 {
				from s12
				to s11
				exec
				condition $PlaceWetFloorSignEnd
			}
			transition t16 {
				from s12
				to s12
				exec
				condition not $PlaceWetFloorSignEnd
			}
			transition t17 {
				from s10
				to s14
				exec
				condition not $prayingTime
			}
			state s14 {
				entry $ WarnAboutWetFloorStart() ; exec
			}
			transition t18 {
				from s14
				to s11
				exec
				condition $WarnAboutWetFloorEnd
			}
			transition t19 {
				from s14
				to s14
				exec
				condition not $WarnAboutWetFloorEnd
			}
			transition t20 {
				from s7
				to s8
				exec
				condition not $floorNeedsCleaning
			}
		}
		connection C on PlaceWetFloorSignEnd to wfSTM on PlaceWetFloorSignEnd (_async)
		connection C on DisplayCleaningPlanEnd to wfSTM on DisplayCleaningPlanEnd (_async)
		connection C on WarnAboutWetFloorEnd to wfSTM on WarnAboutWetFloorEnd (_async)
		connection C on OpenWindowEnd to wfSTM on OpenWindowEnd (_async)
		connection C on AssessRoomEnd to wfSTM on AssessRoomEnd (_async)
		connection C on DustFurnitureEnd to wfSTM on DustFurnitureEnd (_async)
		connection C on CleanFloorEnd to wfSTM on CleanFloorEnd (_async)
		connection C on prayingTime to wfSTM on prayingTime (_async)
		connection C on floorNeedsCleaning to wfSTM on floorNeedsCleaning (_async)
	}
	connection RP on PlaceWetFloorSignEnd to C on PlaceWetFloorSignEnd (_async)
	connection RP on DisplayCleaningPlanEnd to C on DisplayCleaningPlanEnd (_async)
	connection RP on WarnAboutWetFloorEnd to C on WarnAboutWetFloorEnd (_async)
	connection RP on OpenWindowEnd to C on OpenWindowEnd (_async)
	connection RP on AssessRoomEnd to C on AssessRoomEnd (_async)
	connection RP on DustFurnitureEnd to C on DustFurnitureEnd (_async)
	connection RP on CleanFloorEnd to C on CleanFloorEnd (_async)
	connection RP on prayingTime to C on prayingTime (_async)
	connection RP on floorNeedsCleaning to C on floorNeedsCleaning (_async)
}
