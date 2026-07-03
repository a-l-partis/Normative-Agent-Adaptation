interface TasksStartI {
	AlertUserStart()
	beepStart()
	VacuumStart()
	DockStart()
	UndockStart()
	GoToRoomStart()
}
interface TasksEndI {
	event AlertUserEnd
	event beepEnd
	event VacuumEnd
	event DockEnd
	event UndockEnd
	event GoToRoomEnd
}
interface GuardsI {
	event userDustAllergy : boolean
	event userPrayingTime : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			var localuserPrayingTime : boolean
			var localuserDustAllergy : boolean
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
			state s6 {}
			state s5 {}
			state s9 {}
			transition t11 {
				from s9
				to s6
			}
			transition t12 {
				from s5
				to x2
			}
			state x2 {}
			transition t13 {
				from x2
				to x2
				exec
				condition not $userPrayingTime ? localuserPrayingTime
			}
			transition t14 {
				from x2
				to j3
				condition $ userPrayingTime ? localuserPrayingTime
			}
			junction j3
			transition t15 {
				from j3
				to s9
				condition localuserPrayingTime
			}
			transition t16 {
				from j3
				to s11
				condition not localuserPrayingTime
			}
			state s11 {}
			state s12 {}
			transition t17 {
				from s12
				to s9
			}
			transition t18 {
				from s11
				to x4
			}
			state x4 {}
			transition t19 {
				from x4
				to x4
				exec
				condition not $userDustAllergy ? localuserDustAllergy
			}
			transition t20 {
				from x4
				to j5
				condition $ userDustAllergy ? localuserDustAllergy
			}
			junction j5
			transition t21 {
				from j5
				to s13
				condition localuserDustAllergy
			}
			state s13 {
				entry $ AlertUserStart() ; exec
			}
			state x6 {}
			transition t23 {
				from x6
				to x6
				exec
				condition not $AlertUserEnd
			}
			transition t24 {
				from s13
				to x6
			}
			transition t25 {
				from x6
				to s12
				exec
				condition $AlertUserEnd
			}
			transition t27 {
				from j5
				to s12
				condition not localuserDustAllergy
			}
			transition t28 {
				from s6
				to s17
			}
			state s17 {
				entry $ VacuumStart() ; exec
			}
			state x7 {}
			transition t30 {
				from x7
				to x7
				exec
				condition not $VacuumEnd
			}
			transition t31 {
				from s17
				to x7
			}
			transition t32 {
				from x7
				to s19
				exec
				condition $VacuumEnd
			}
			state s19 {
				entry $ beepStart() ; exec
			}
			state x8 {}
			transition t35 {
				from x8
				to x8
				exec
				condition not $beepEnd
			}
			transition t36 {
				from s19
				to x8
			}
			transition t37 {
				from x8
				to s20
				exec
				condition $beepEnd
			}
			state s20 {
				entry $ DockStart() ; exec
			}
			state x9 {}
			transition t40 {
				from x9
				to x9
				exec
				condition not $DockEnd
			}
			transition t41 {
				from s20
				to x9
			}
			transition t42 {
				from x9
				to s2
				exec
				condition $DockEnd
			}
		}
		connection C on AlertUserEnd to wfSTM on AlertUserEnd (_async)
		connection C on beepEnd to wfSTM on beepEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on DockEnd to wfSTM on DockEnd (_async)
		connection C on UndockEnd to wfSTM on UndockEnd (_async)
		connection C on GoToRoomEnd to wfSTM on GoToRoomEnd (_async)
		connection C on userDustAllergy to wfSTM on userDustAllergy (_async)
		connection C on userPrayingTime to wfSTM on userPrayingTime (_async)
	}
	connection RP on AlertUserEnd to C on AlertUserEnd (_async)
	connection RP on beepEnd to C on beepEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on DockEnd to C on DockEnd (_async)
	connection RP on UndockEnd to C on UndockEnd (_async)
	connection RP on GoToRoomEnd to C on GoToRoomEnd (_async)
	connection RP on userDustAllergy to C on userDustAllergy (_async)
	connection RP on userPrayingTime to C on userPrayingTime (_async)
}
