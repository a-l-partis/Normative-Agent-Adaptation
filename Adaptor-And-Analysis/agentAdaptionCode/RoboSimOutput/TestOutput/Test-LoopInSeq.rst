interface TasksStartI {
	AlertUserStart()
	VacuumStart()
	LeaveRoomStart()
	UndockStart()
}
interface TasksEndI {
	event AlertUserEnd
	event VacuumEnd
	event LeaveRoomEnd
	event UndockEnd
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
			state s4 {}
			transition t6 {
				from s4
				to s4
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t7 {
				from s4
				to x1
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state s11 {}
			state x1 {}
			transition t8 {
				from x1
				to s11
			}
			transition t9 {
				from s11
				to s12
				condition localneedsVacuuming
			}
			state s19 {}
			state s12 {
				entry $ AlertUserStart() ; exec
			}
			state x2 {}
			transition t11 {
				from x2
				to x2
				exec
				condition not $AlertUserEnd
			}
			transition t12 {
				from s12
				to x2
			}
			transition t13 {
				from x2
				to s13
				exec
				condition $AlertUserEnd
			}
			state s13 {
				entry $ VacuumStart() ; exec
			}
			state x3 {}
			transition t16 {
				from x3
				to x3
				exec
				condition not $VacuumEnd
			}
			transition t17 {
				from s13
				to x3
			}
			transition t18 {
				from x3
				to s14
				exec
				condition $VacuumEnd
			}
			state s14 {
				entry $ LeaveRoomStart() ; exec
			}
			state x4 {}
			transition t21 {
				from x4
				to x4
				exec
				condition not $LeaveRoomEnd
			}
			transition t22 {
				from s14
				to x4
			}
			transition t23 {
				from x4
				to s19
				exec
				condition $LeaveRoomEnd
			}
			transition t25 {
				from s19
				to x7
				exec			}
			state x7 {}
			transition t26 {
				from x7
				to x7
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t27 {
				from x7
				to x8
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x8 {}
			transition t28 {
				from x8
				to s11
			}
			transition t29 {
				from s11
				to s2
				condition not localneedsVacuuming
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
}
