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
			var localdaytime : boolean
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
				condition not $daytime ? localdaytime
			}
			transition t4 {
				from x0
				to j1
				condition $ daytime ? localdaytime
			}
			junction j1
			transition t5 {
				from j1
				to s5
				condition localdaytime
			}
			state s5 {}
			transition t6 {
				from s5
				to s5
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t7 {
				from s5
				to x2
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state s12 {}
			state x2 {}
			transition t8 {
				from x2
				to s12
			}
			transition t9 {
				from s12
				to s13
				condition localneedsVacuuming
			}
			state s20 {}
			state s13 {
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
				from s13
				to x3
			}
			transition t13 {
				from x3
				to s14
				exec
				condition $AlertUserEnd
			}
			state s14 {
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
				from s14
				to x4
			}
			transition t18 {
				from x4
				to s15
				exec
				condition $VacuumEnd
			}
			state s15 {
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
				from s15
				to x5
			}
			transition t23 {
				from x5
				to s20
				exec
				condition $LeaveRoomEnd
			}
			transition t25 {
				from s20
				to x8
				exec			}
			state x8 {}
			transition t26 {
				from x8
				to x8
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t27 {
				from x8
				to x9
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x9 {}
			transition t28 {
				from x9
				to s12
			}
			transition t29 {
				from s12
				to s4
				condition not localneedsVacuuming
			}
			transition t30 {
				from j1
				to s4
				condition not localdaytime
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
		connection C on daytime to wfSTM on daytime (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
	connection RP on daytime to C on daytime (_async)
}
