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
			var localneedsVacuuming : boolean
			var localpersonPresent : boolean
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
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t4 {
				from x0
				to j1
				condition $ needsVacuuming ? localneedsVacuuming
			}
			junction j1
			transition t5 {
				from j1
				to s5
				condition localneedsVacuuming
			}
			state s5 {}
			state s6 {}
			transition t6 {
				from s6
				to s4
			}
			transition t7 {
				from s5
				to x2
			}
			state x2 {}
			transition t8 {
				from x2
				to x2
				exec
				condition not $personPresent ? localpersonPresent
			}
			transition t9 {
				from x2
				to j3
				condition $ personPresent ? localpersonPresent
			}
			junction j3
			transition t10 {
				from j3
				to s7
				condition not localpersonPresent
			}
			state s7 {
				entry $ AlertUserStart() ; exec
			}
			state x4 {}
			transition t12 {
				from x4
				to x4
				exec
				condition not $AlertUserEnd
			}
			transition t13 {
				from s7
				to x4
			}
			transition t14 {
				from x4
				to s8
				exec
				condition $AlertUserEnd
			}
			state s8 {
				entry $ VacuumStart() ; exec
			}
			state x5 {}
			transition t17 {
				from x5
				to x5
				exec
				condition not $VacuumEnd
			}
			transition t18 {
				from s8
				to x5
			}
			transition t19 {
				from x5
				to s9
				exec
				condition $VacuumEnd
			}
			state s9 {
				entry $ LeaveRoomStart() ; exec
			}
			state x6 {}
			transition t22 {
				from x6
				to x6
				exec
				condition not $LeaveRoomEnd
			}
			transition t23 {
				from s9
				to x6
			}
			transition t24 {
				from x6
				to s6
				exec
				condition $LeaveRoomEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
		connection C on personPresent to wfSTM on personPresent (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
	connection RP on personPresent to C on personPresent (_async)
}
