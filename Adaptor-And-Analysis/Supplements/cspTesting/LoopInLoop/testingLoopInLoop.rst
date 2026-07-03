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
	event personPresent : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			var localpersonPresent : boolean
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
				condition not $personPresent ? localpersonPresent
			}
			transition t2 {
				from s1
				to x0
				condition $ personPresent ? localpersonPresent
			}
			state s17 {}
			state x0 {}
			transition t3 {
				from x0
				to s17
			}
			transition t4 {
				from s17
				to s18
				condition not localpersonPresent
			}
			state s32 {}
			state s18 {}
			transition t5 {
				from s18
				to s18
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t6 {
				from s18
				to x1
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state s25 {}
			state x1 {}
			transition t7 {
				from x1
				to s25
			}
			transition t8 {
				from s25
				to s26
				condition localneedsVacuuming
			}
			state s33 {}
			state s26 {
				entry $ AlertUserStart() ; exec
			}
			state x2 {}
			transition t10 {
				from x2
				to x2
				exec
				condition not $AlertUserEnd
			}
			transition t11 {
				from s26
				to x2
			}
			transition t12 {
				from x2
				to s27
				exec
				condition $AlertUserEnd
			}
			state s27 {
				entry $ VacuumStart() ; exec
			}
			state x3 {}
			transition t15 {
				from x3
				to x3
				exec
				condition not $VacuumEnd
			}
			transition t16 {
				from s27
				to x3
			}
			transition t17 {
				from x3
				to s28
				exec
				condition $VacuumEnd
			}
			state s28 {
				entry $ LeaveRoomStart() ; exec
			}
			state x4 {}
			transition t20 {
				from x4
				to x4
				exec
				condition not $LeaveRoomEnd
			}
			transition t21 {
				from s28
				to x4
			}
			transition t22 {
				from x4
				to s33
				exec
				condition $LeaveRoomEnd
			}
			transition t24 {
				from s33
				to x7
				exec			}
			state x7 {}
			transition t25 {
				from x7
				to x7
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t26 {
				from x7
				to x8
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x8 {}
			transition t27 {
				from x8
				to s25
			}
			transition t28 {
				from s25
				to s32
				condition not localneedsVacuuming
			}
			transition t29 {
				from s32
				to x11
				exec			}
			state x11 {}
			transition t30 {
				from x11
				to x11
				exec
				condition not $personPresent ? localpersonPresent
			}
			transition t31 {
				from x11
				to x12
				condition $ personPresent ? localpersonPresent
			}
			state x12 {}
			transition t32 {
				from x12
				to s17
			}
			transition t33 {
				from s17
				to s2
				condition localpersonPresent
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
