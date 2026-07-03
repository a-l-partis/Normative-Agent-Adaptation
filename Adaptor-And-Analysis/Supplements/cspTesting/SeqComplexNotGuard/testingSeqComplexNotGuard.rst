interface TasksStartI {
	beepStart()
	VacuumStart()
	DockStart()
	UndockStart()
	ReturnToDockStart()
	GoToRoomStart()
}
interface TasksEndI {
	event beepEnd
	event VacuumEnd
	event DockEnd
	event UndockEnd
	event ReturnToDockEnd
	event GoToRoomEnd
}
interface GuardsI {
	event wayBlocked : boolean
	event daytime : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			var localwayBlocked : boolean
			var localdaytime : boolean
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
				entry $ GoToRoomStart() ; exec
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $GoToRoomEnd
			}
			transition t8 {
				from s4
				to x1
			}
			transition t9 {
				from x1
				to s5
				exec
				condition $GoToRoomEnd
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
			state s7 {}
			state s6 {}
			state s10 {}
			transition t16 {
				from s10
				to s7
			}
			transition t17 {
				from s6
				to x3
			}
			state x3 {}
			transition t18 {
				from x3
				to x3
				exec
				condition not $wayBlocked ? localwayBlocked
			}
			transition t19 {
				from x3
				to x4
				condition $ wayBlocked ? localwayBlocked
			}
			state x4 {}
			transition t20 {
				from x4
				to x4
				exec
				condition not $daytime ? localdaytime
			}
			transition t21 {
				from x4
				to j5
				condition $ daytime ? localdaytime
			}
			junction j5
			transition t22 {
				from j5
				to s11
				condition (localwayBlocked /\ not localdaytime)
			}
			state s11 {
				entry $ ReturnToDockStart() ; exec
			}
			state x6 {}
			transition t24 {
				from x6
				to x6
				exec
				condition not $ReturnToDockEnd
			}
			transition t25 {
				from s11
				to x6
			}
			transition t26 {
				from x6
				to s10
				exec
				condition $ReturnToDockEnd
			}
			transition t28 {
				from j5
				to s10
				condition not (localwayBlocked /\ not localdaytime)
			}
			transition t29 {
				from s7
				to s14
			}
			state s14 {
				entry $ beepStart() ; exec
			}
			state x7 {}
			transition t31 {
				from x7
				to x7
				exec
				condition not $beepEnd
			}
			transition t32 {
				from s14
				to x7
			}
			transition t33 {
				from x7
				to s16
				exec
				condition $beepEnd
			}
			state s16 {
				entry $ DockStart() ; exec
			}
			state x8 {}
			transition t36 {
				from x8
				to x8
				exec
				condition not $DockEnd
			}
			transition t37 {
				from s16
				to x8
			}
			transition t38 {
				from x8
				to s2
				exec
				condition $DockEnd
			}
		}
		connection C on beepEnd to wfSTM on beepEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
		connection C on ReturnToDockEnd to wfSTM on ReturnToDockEnd (_async)
		connection C on GoToRoomEnd to wfSTM on GoToRoomEnd (_async)
		connection C on wayBlocked to wfSTM on wayBlocked (_async)
		connection C on daytime to wfSTM on daytime (_async)
	}
	connection RP on beepEnd to C on beepEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
	connection RP on ReturnToDockEnd to C on ReturnToDockEnd (_async)
	connection RP on GoToRoomEnd to C on GoToRoomEnd (_async)
	connection RP on wayBlocked to C on wayBlocked (_async)
	connection RP on daytime to C on daytime (_async)
}
