interface TasksStartI {
	VacuumStart()
	ReturnToDockStart()
}
interface TasksEndI {
	event VacuumEnd
	event ReturnToDockEnd
}
interface GuardsI {
	event needsVacuuming : boolean
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
			var localneedsVacuuming : boolean
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
			state s22 {}
			state x0 {}
			transition t3 {
				from x0
				to s22
			}
			transition t4 {
				from s22
				to s23
				condition localneedsVacuuming
			}
			state s42 {}
			state s23 {
				entry $ VacuumStart() ; exec
			}
			state x1 {}
			transition t6 {
				from x1
				to x1
				exec
				condition not $VacuumEnd
			}
			transition t7 {
				from s23
				to x1
			}
			transition t8 {
				from x1
				to s24
				exec
				condition $VacuumEnd
			}
			state s24 {}
			state s25 {}
			transition t10 {
				from s25
				to s42
			}
			transition t11 {
				from s24
				to x2
			}
			state x2 {}
			transition t12 {
				from x2
				to x2
				exec
				condition not $wayBlocked ? localwayBlocked
			}
			transition t13 {
				from x2
				to x3
				condition $ wayBlocked ? localwayBlocked
			}
			state x3 {}
			transition t14 {
				from x3
				to x3
				exec
				condition not $daytime ? localdaytime
			}
			transition t15 {
				from x3
				to j4
				condition $ daytime ? localdaytime
			}
			junction j4
			transition t16 {
				from j4
				to s26
				condition (localwayBlocked /\ not localdaytime)
			}
			state s26 {
				entry $ ReturnToDockStart() ; exec
			}
			state x5 {}
			transition t18 {
				from x5
				to x5
				exec
				condition not $ReturnToDockEnd
			}
			transition t19 {
				from s26
				to x5
			}
			transition t20 {
				from x5
				to s25
				exec
				condition $ReturnToDockEnd
			}
			transition t22 {
				from j4
				to s25
				condition not (localwayBlocked /\ not localdaytime)
			}
			transition t23 {
				from s42
				to x8
				exec			}
			state x8 {}
			transition t24 {
				from x8
				to x8
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t25 {
				from x8
				to x9
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x9 {}
			transition t26 {
				from x9
				to s22
			}
			transition t27 {
				from s22
				to s2
				condition not localneedsVacuuming
			}
		}
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on ReturnToDockEnd to wfSTM on ReturnToDockEnd (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
		connection C on wayBlocked to wfSTM on wayBlocked (_async)
		connection C on daytime to wfSTM on daytime (_async)
	}
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on ReturnToDockEnd to C on ReturnToDockEnd (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
	connection RP on wayBlocked to C on wayBlocked (_async)
	connection RP on daytime to C on daytime (_async)
}
