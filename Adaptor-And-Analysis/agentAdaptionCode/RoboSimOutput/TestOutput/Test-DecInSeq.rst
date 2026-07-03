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
			state s5 {}
			transition t6 {
				from s5
				to s2
			}
			transition t7 {
				from s4
				to x1
			}
			state x1 {}
			transition t8 {
				from x1
				to x1
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t9 {
				from x1
				to j2
				condition $ needsVacuuming ? localneedsVacuuming
			}
			junction j2
			transition t10 {
				from j2
				to s6
				condition localneedsVacuuming
			}
			state s6 {
				entry $ AlertUserStart() ; exec
			}
			state x3 {}
			transition t12 {
				from x3
				to x3
				exec
				condition not $AlertUserEnd
			}
			transition t13 {
				from s6
				to x3
			}
			transition t14 {
				from x3
				to s7
				exec
				condition $AlertUserEnd
			}
			state s7 {
				entry $ VacuumStart() ; exec
			}
			state x4 {}
			transition t17 {
				from x4
				to x4
				exec
				condition not $VacuumEnd
			}
			transition t18 {
				from s7
				to x4
			}
			transition t19 {
				from x4
				to s8
				exec
				condition $VacuumEnd
			}
			state s8 {
				entry $ LeaveRoomStart() ; exec
			}
			state x5 {}
			transition t22 {
				from x5
				to x5
				exec
				condition not $LeaveRoomEnd
			}
			transition t23 {
				from s8
				to x5
			}
			transition t24 {
				from x5
				to s5
				exec
				condition $LeaveRoomEnd
			}
			transition t26 {
				from j2
				to s5
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
