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
				entry $ AlertUserStart() ; exec
			}
			state x0 {}
			transition t2 {
				from x0
				to x0
				exec
				condition not $AlertUserEnd
			}
			transition t3 {
				from s1
				to x0
			}
			transition t4 {
				from x0
				to s4
				exec
				condition $AlertUserEnd
			}
			state s4 {
				entry $ VacuumStart() ; exec
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $VacuumEnd
			}
			transition t8 {
				from s4
				to x1
			}
			transition t9 {
				from x1
				to s5
				exec
				condition $VacuumEnd
			}
			state s5 {
				entry $ LeaveRoomStart() ; exec
			}
			state x2 {}
			transition t12 {
				from x2
				to x2
				exec
				condition not $LeaveRoomEnd
			}
			transition t13 {
				from s5
				to x2
			}
			transition t14 {
				from x2
				to s2
				exec
				condition $LeaveRoomEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
}
