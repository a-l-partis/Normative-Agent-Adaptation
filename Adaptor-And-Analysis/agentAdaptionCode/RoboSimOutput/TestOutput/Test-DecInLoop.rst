interface TasksStartI {
	AlertUserStart()
	VacuumStart()
	LeaveRoomStart()
}
interface TasksEndI {
	event AlertUserEnd
	event VacuumEnd
	event LeaveRoomEnd
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
			var localuserPraying : boolean
			var localneedsVacuuming : boolean
			input context { uses TasksEndI uses GuardsI }
			output context { requires TasksStartI }
			cycleDef true
			initial s0
			transition t0 {
				from s0
				to s1
			}
			final s2
			state s1 {}
			transition t1 {
				from s1
				to s1
				exec
				condition not $userPraying ? localuserPraying
			}
			transition t2 {
				from s1
				to x0
				condition $ userPraying ? localuserPraying
			}
			state s20 {}
			state x0 {}
			transition t3 {
				from x0
				to s20
			}
			transition t4 {
				from s20
				to s21
				condition not localuserPraying
			}
			state s38 {}
			state s21 {}
			state s22 {}
			transition t5 {
				from s22
				to s38
			}
			transition t6 {
				from s21
				to x1
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t8 {
				from x1
				to j2
				condition $ needsVacuuming ? localneedsVacuuming
			}
			junction j2
			transition t9 {
				from j2
				to s23
				condition localneedsVacuuming
			}
			state s23 {
				entry $ AlertUserStart() ; exec
			}
			state x3 {}
			transition t11 {
				from x3
				to x3
				exec
				condition not $AlertUserEnd
			}
			transition t12 {
				from s23
				to x3
			}
			transition t13 {
				from x3
				to s24
				exec
				condition $AlertUserEnd
			}
			state s24 {
				entry $ VacuumStart() ; exec
			}
			state x4 {}
			transition t16 {
				from x4
				to x4
				exec
				condition not $VacuumEnd
			}
			transition t17 {
				from s24
				to x4
			}
			transition t18 {
				from x4
				to s25
				exec
				condition $VacuumEnd
			}
			state s25 {
				entry $ LeaveRoomStart() ; exec
			}
			state x5 {}
			transition t21 {
				from x5
				to x5
				exec
				condition not $LeaveRoomEnd
			}
			transition t22 {
				from s25
				to x5
			}
			transition t23 {
				from x5
				to s22
				exec
				condition $LeaveRoomEnd
			}
			transition t25 {
				from j2
				to s22
				condition not localneedsVacuuming
			}
			transition t26 {
				from s38
				to x8
				exec			}
			state x8 {}
			transition t27 {
				from x8
				to x8
				exec
				condition not $userPraying ? localuserPraying
			}
			transition t28 {
				from x8
				to x9
				condition $ userPraying ? localuserPraying
			}
			state x9 {}
			transition t29 {
				from x9
				to s20
			}
			transition t30 {
				from s20
				to s2
				condition localuserPraying
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
		connection C on userPraying to wfSTM on userPraying (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
	connection RP on userPraying to C on userPraying (_async)
}
