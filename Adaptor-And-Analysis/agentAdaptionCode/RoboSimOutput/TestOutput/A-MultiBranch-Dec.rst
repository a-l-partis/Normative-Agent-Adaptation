interface TasksStartI {
	AlertUserStart()
	VacuumStart()
	DockStart()
	LeaveRoomStart()
}
interface TasksEndI {
	event AlertUserEnd
	event VacuumEnd
	event DockEnd
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
				to x1
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x1 {}
			transition t5 {
				from x1
				to x1
				exec
				condition not $personPresent ? localpersonPresent
			}
			transition t6 {
				from x1
				to j2
				condition $ personPresent ? localpersonPresent
			}
			junction j2
			transition t7 {
				from j2
				to s5
				condition (localneedsVacuuming /\ not localpersonPresent)
			}
			state s5 {
				entry $ AlertUserStart() ; exec
			}
			state x3 {}
			transition t9 {
				from x3
				to x3
				exec
				condition not $AlertUserEnd
			}
			transition t10 {
				from s5
				to x3
			}
			transition t11 {
				from x3
				to s6
				exec
				condition $AlertUserEnd
			}
			state s6 {
				entry $ VacuumStart() ; exec
			}
			state x4 {}
			transition t14 {
				from x4
				to x4
				exec
				condition not $VacuumEnd
			}
			transition t15 {
				from s6
				to x4
			}
			transition t16 {
				from x4
				to s7
				exec
				condition $VacuumEnd
			}
			state s7 {
				entry $ LeaveRoomStart() ; exec
			}
			state x5 {}
			transition t19 {
				from x5
				to x5
				exec
				condition not $LeaveRoomEnd
			}
			transition t20 {
				from s7
				to x5
			}
			transition t21 {
				from x5
				to s4
				exec
				condition $LeaveRoomEnd
			}
			transition t23 {
				from j2
				to s4
				condition not localneedsVacuuming
			}
			transition t24 {
				from j2
				to s10
				condition localpersonPresent
			}
			state s10 {
				entry $ DockStart() ; exec
			}
			state x6 {}
			transition t26 {
				from x6
				to x6
				exec
				condition not $DockEnd
			}
			transition t27 {
				from s10
				to x6
			}
			transition t28 {
				from x6
				to s4
				exec
				condition $DockEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
		connection C on personPresent to wfSTM on personPresent (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
	connection RP on personPresent to C on personPresent (_async)
}
