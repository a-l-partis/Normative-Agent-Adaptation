interface TasksStartI {
	AlertUserStart()
	VacuumStart()
	DockStart()
	LeaveRoomStart()
	UndockStart()
}
interface TasksEndI {
	event AlertUserEnd
	event VacuumEnd
	event DockEnd
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
				entry $ AlertUserStart() ; exec
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $AlertUserEnd
			}
			transition t8 {
				from s4
				to x1
			}
			transition t9 {
				from x1
				to s5
				exec
				condition $AlertUserEnd
			}
			state s5 {
				entry $ VacuumStart() ; exec
			}
			state x2 {}
			transition t12 {
				from x2
				to x2
				exec
				condition not $VacuumEnd
			}
			transition t13 {
				from s5
				to x2
			}
			transition t14 {
				from x2
				to s6
				exec
				condition $VacuumEnd
			}
			state s6 {
				entry $ LeaveRoomStart() ; exec
			}
			state x3 {}
			transition t17 {
				from x3
				to x3
				exec
				condition not $LeaveRoomEnd
			}
			transition t18 {
				from s6
				to x3
			}
			transition t19 {
				from x3
				to s7
				exec
				condition $LeaveRoomEnd
			}
			state s7 {
				entry $ DockStart() ; exec
			}
			state x4 {}
			transition t22 {
				from x4
				to x4
				exec
				condition not $DockEnd
			}
			transition t23 {
				from s7
				to x4
			}
			transition t24 {
				from x4
				to s2
				exec
				condition $DockEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
}
