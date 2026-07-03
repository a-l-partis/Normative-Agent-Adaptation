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
	event needsVacuuming : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
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
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t2 {
				from s1
				to x0
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state s10 {}
			state x0 {}
			transition t3 {
				from x0
				to s10
			}
			transition t4 {
				from s10
				to s11
				condition localneedsVacuuming
			}
			state s18 {}
			state s11 {
				entry $ AlertUserStart() ; exec
			}
			state x1 {}
			transition t6 {
				from x1
				to x1
				exec
				condition not $AlertUserEnd
			}
			transition t7 {
				from s11
				to x1
			}
			transition t8 {
				from x1
				to s12
				exec
				condition $AlertUserEnd
			}
			state s12 {
				entry $ VacuumStart() ; exec
			}
			state x2 {}
			transition t11 {
				from x2
				to x2
				exec
				condition not $VacuumEnd
			}
			transition t12 {
				from s12
				to x2
			}
			transition t13 {
				from x2
				to s13
				exec
				condition $VacuumEnd
			}
			state s13 {
				entry $ LeaveRoomStart() ; exec
			}
			state x3 {}
			transition t16 {
				from x3
				to x3
				exec
				condition not $LeaveRoomEnd
			}
			transition t17 {
				from s13
				to x3
			}
			transition t18 {
				from x3
				to s18
				exec
				condition $LeaveRoomEnd
			}
			transition t20 {
				from s18
				to x6
				exec			}
			state x6 {}
			transition t21 {
				from x6
				to x6
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t22 {
				from x6
				to x7
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x7 {}
			transition t23 {
				from x7
				to s10
			}
			transition t24 {
				from s10
				to s2
				condition not localneedsVacuuming
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
}
