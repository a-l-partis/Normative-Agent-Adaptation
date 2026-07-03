interface TasksStartI {
	AlertUserStart()
	beepStart()
	VacuumStart()
	DockStart()
	LeaveRoomStart()
	UndockStart()
	GoToRoomStart()
}
interface TasksEndI {
	event AlertUserEnd
	event beepEnd
	event VacuumEnd
	event DockEnd
	event LeaveRoomEnd
	event UndockEnd
	event GoToRoomEnd
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
			state s18 {}
			state x0 {}
			transition t3 {
				from x0
				to s18
			}
			transition t4 {
				from s18
				to s19
				condition localneedsVacuuming
			}
			state s34 {}
			state s19 {
				entry $ UndockStart() ; exec
			}
			state x1 {}
			transition t6 {
				from x1
				to x1
				exec
				condition not $UndockEnd
			}
			transition t7 {
				from s19
				to x1
			}
			transition t8 {
				from x1
				to s20
				exec
				condition $UndockEnd
			}
			state s20 {
				entry $ GoToRoomStart() ; exec
			}
			state x2 {}
			transition t11 {
				from x2
				to x2
				exec
				condition not $GoToRoomEnd
			}
			transition t12 {
				from s20
				to x2
			}
			transition t13 {
				from x2
				to s21
				exec
				condition $GoToRoomEnd
			}
			state s21 {
				entry $ AlertUserStart() ; exec
			}
			state x3 {}
			transition t16 {
				from x3
				to x3
				exec
				condition not $AlertUserEnd
			}
			transition t17 {
				from s21
				to x3
			}
			transition t18 {
				from x3
				to s22
				exec
				condition $AlertUserEnd
			}
			state s22 {
				entry $ VacuumStart() ; exec
			}
			state x4 {}
			transition t21 {
				from x4
				to x4
				exec
				condition not $VacuumEnd
			}
			transition t22 {
				from s22
				to x4
			}
			transition t23 {
				from x4
				to s23
				exec
				condition $VacuumEnd
			}
			state s23 {
				entry $ LeaveRoomStart() ; exec
			}
			state x5 {}
			transition t26 {
				from x5
				to x5
				exec
				condition not $LeaveRoomEnd
			}
			transition t27 {
				from s23
				to x5
			}
			transition t28 {
				from x5
				to s24
				exec
				condition $LeaveRoomEnd
			}
			state s24 {
				entry $ beepStart() ; exec
			}
			state x6 {}
			transition t31 {
				from x6
				to x6
				exec
				condition not $beepEnd
			}
			transition t32 {
				from s24
				to x6
			}
			transition t33 {
				from x6
				to s25
				exec
				condition $beepEnd
			}
			state s25 {
				entry $ DockStart() ; exec
			}
			state x7 {}
			transition t36 {
				from x7
				to x7
				exec
				condition not $DockEnd
			}
			transition t37 {
				from s25
				to x7
			}
			transition t38 {
				from x7
				to s34
				exec
				condition $DockEnd
			}
			transition t40 {
				from s34
				to x10
				exec			}
			state x10 {}
			transition t41 {
				from x10
				to x10
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t42 {
				from x10
				to x11
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x11 {}
			transition t43 {
				from x11
				to s18
			}
			transition t44 {
				from s18
				to s2
				condition not localneedsVacuuming
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on beepEnd to wfSTM on beepEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on LeaveRoomEnd to wfSTM on LeaveRoomEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
		connection C on GoToRoomEnd to wfSTM on GoToRoomEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on beepEnd to C on beepEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on LeaveRoomEnd to C on LeaveRoomEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
	connection RP on GoToRoomEnd to C on GoToRoomEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
}
