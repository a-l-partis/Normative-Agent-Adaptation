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
			var localnumTimesVacuumed : real
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
			state s4 {}
			transition t1 {
				from s4
				to s2
			}
			transition t2 {
				from s1
				to x0
			}
			state x0 {}
			transition t3 {
				from x0
				to x0
				exec
				condition not $numTimesVacuumed ? localnumTimesVacuumed
			}
			transition t4 {
				from x0
				to j1
				condition $ numTimesVacuumed ? localnumTimesVacuumed
			}
			junction j1
			transition t5 {
				from j1
				to s5
				condition (localnumTimesVacuumed == 0)
			}
			state s5 {
				entry $ AlertUserStart() ; exec
			}
			state x2 {}
			transition t7 {
				from x2
				to x2
				exec
				condition not $AlertUserEnd
			}
			transition t8 {
				from s5
				to x2
			}
			transition t9 {
				from x2
				to s6
				exec
				condition $AlertUserEnd
			}
			state s6 {
				entry $ VacuumStart() ; exec
			}
			state x3 {}
			transition t12 {
				from x3
				to x3
				exec
				condition not $VacuumEnd
			}
			transition t13 {
				from s6
				to x3
			}
			transition t14 {
				from x3
				to s7
				exec
				condition $VacuumEnd
			}
			state s7 {
				entry $ LeaveRoomStart() ; exec
			}
			state x4 {}
			transition t17 {
				from x4
				to x4
				exec
				condition not $LeaveRoomEnd
			}
			transition t18 {
				from s7
				to x4
			}
			transition t19 {
				from x4
				to s4
				exec
				condition $LeaveRoomEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on numTimesVacuumed to wfSTM on numTimesVacuumed (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on numTimesVacuumed to C on numTimesVacuumed (_async)
}
