interface TasksStartI {
	beepStart()
	VacuumStart()
	DockStart()
	UndockStart()
	SetSilentCleaningModeStart()
	GoToRoomStart()
}
interface TasksEndI {
	event beepEnd
	event VacuumEnd
	event DockEnd
	event UndockEnd
	event SetSilentCleaningModeEnd
	event GoToRoomEnd
}
interface GuardsI {
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			var localuserSleeping : boolean
			var localuserDustAllergy : boolean
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
				entry $ UndockStart() ; exec
			}
			state x0 {}
			transition t2 {
				from x0
				to x0
				exec
				condition not $UndockEnd
			}
			transition t3 {
				from s1
				to x0
			}
			transition t4 {
				from x0
				to s4
				exec
				condition $UndockEnd
			}
			state s4 {
				entry $ GoToRoomStart() ; exec
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $GoToRoomEnd
			}
			transition t8 {
				from s4
				to x1
			}
			transition t9 {
				from x1
				to s5
				exec
				condition $GoToRoomEnd
			}
			state s6 {}
			state s5 {}
			state s9 {}
			transition t11 {
				from s9
				to s6
			}
			transition t12 {
				from s5
				to x2
			}
			state x2 {}
			transition t13 {
				from x2
				to x2
				exec
				condition not $userSleeping ? localuserSleeping
			}
			transition t14 {
				from x2
				to x3
				condition $ userSleeping ? localuserSleeping
			}
			state x3 {}
			transition t15 {
				from x3
				to x3
				exec
				condition not $userDustAllergy ? localuserDustAllergy
			}
			transition t16 {
				from x3
				to j4
				condition $ userDustAllergy ? localuserDustAllergy
			}
			junction j4
			transition t17 {
				from j4
				to s10
				condition (localuserSleeping \/ localuserDustAllergy)
			}
			state s10 {
				entry $ SetSilentCleaningModeStart() ; exec
			}
			state x5 {}
			transition t19 {
				from x5
				to x5
				exec
				condition not $SetSilentCleaningModeEnd
			}
			transition t20 {
				from s10
				to x5
			}
			transition t21 {
				from x5
				to s9
				exec
				condition $SetSilentCleaningModeEnd
			}
			transition t23 {
				from j4
				to s9
				condition not (localuserSleeping \/ localuserDustAllergy)
			}
			transition t24 {
				from s6
				to s13
			}
			state s13 {
				entry $ VacuumStart() ; exec
			}
			state x6 {}
			transition t26 {
				from x6
				to x6
				exec
				condition not $VacuumEnd
			}
			transition t27 {
				from s13
				to x6
			}
			transition t28 {
				from x6
				to s15
				exec
				condition $VacuumEnd
			}
			state s15 {
				entry $ beepStart() ; exec
			}
			state x7 {}
			transition t31 {
				from x7
				to x7
				exec
				condition not $beepEnd
			}
			transition t32 {
				from s15
				to x7
			}
			transition t33 {
				from x7
				to s16
				exec
				condition $beepEnd
			}
			state s16 {
				entry $ DockStart() ; exec
			}
			state x8 {}
			transition t36 {
				from x8
				to x8
				exec
				condition not $DockEnd
			}
			transition t37 {
				from s16
				to x8
			}
			transition t38 {
				from x8
				to s2
				exec
				condition $DockEnd
			}
		}
		connection C on beepEnd to wfSTM on beepEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
		connection C on SetSilentCleaningModeEnd to wfSTM on SetSilentCleaningModeEnd (_async)
		connection C on GoToRoomEnd to wfSTM on GoToRoomEnd (_async)
		connection C on userSleeping to wfSTM on userSleeping (_async)
		connection C on userDustAllergy to wfSTM on userDustAllergy (_async)
	}
	connection RP on beepEnd to C on beepEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
	connection RP on SetSilentCleaningModeEnd to C on SetSilentCleaningModeEnd (_async)
	connection RP on GoToRoomEnd to C on GoToRoomEnd (_async)
	connection RP on userSleeping to C on userSleeping (_async)
	connection RP on userDustAllergy to C on userDustAllergy (_async)
}
