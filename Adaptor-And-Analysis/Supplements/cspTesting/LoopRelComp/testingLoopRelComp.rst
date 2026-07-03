interface TasksStartI {
	PauseStart()
	VacuumStart()
}
interface TasksEndI {
	event PauseEnd
	event VacuumEnd
}
interface GuardsI {
	event unmappedBumperCount : real
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
			var localunmappedBumperCount : real
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
			state s20 {}
			state s19 {}
			state s23 {}
			transition t5 {
				from s23
				to s20
			}
			transition t6 {
				from s19
				to x1
			}
			state x1 {}
			transition t7 {
				from x1
				to x1
				exec
				condition not $unmappedBumperCount ? localunmappedBumperCount
			}
			transition t8 {
				from x1
				to j2
				condition $ unmappedBumperCount ? localunmappedBumperCount
			}
			junction j2
			transition t9 {
				from j2
				to s24
				condition (localunmappedBumperCount > 10)
			}
			state s24 {
				entry $ PauseStart() ; exec
			}
			state x3 {}
			transition t11 {
				from x3
				to x3
				exec
				condition not $PauseEnd
			}
			transition t12 {
				from s24
				to x3
			}
			transition t13 {
				from x3
				to s23
				exec
				condition $PauseEnd
			}
			transition t15 {
				from j2
				to s23
				condition not (localunmappedBumperCount > 10)
			}
			transition t16 {
				from s20
				to s27
			}
			state s27 {
				entry $ VacuumStart() ; exec
			}
			state x4 {}
			transition t18 {
				from x4
				to x4
				exec
				condition not $VacuumEnd
			}
			transition t19 {
				from s27
				to x4
			}
			transition t20 {
				from x4
				to s34
				exec
				condition $VacuumEnd
			}
			transition t22 {
				from s34
				to x7
				exec			}
			state x7 {}
			transition t23 {
				from x7
				to x7
				exec
				condition not $needsVacuuming ? localneedsVacuuming
			}
			transition t24 {
				from x7
				to x8
				condition $ needsVacuuming ? localneedsVacuuming
			}
			state x8 {}
			transition t25 {
				from x8
				to s18
			}
			transition t26 {
				from s18
				to s2
				condition not localneedsVacuuming
			}
		}
		connection C on PauseEnd to wfSTM on PauseEnd (_async)
		connection C on VacuumEnd to wfSTM on VacuumEnd (_async)
		connection C on unmappedBumperCount to wfSTM on unmappedBumperCount (_async)
		connection C on needsVacuuming to wfSTM on needsVacuuming (_async)
	}
	connection RP on PauseEnd to C on PauseEnd (_async)
	connection RP on VacuumEnd to C on VacuumEnd (_async)
	connection RP on unmappedBumperCount to C on unmappedBumperCount (_async)
	connection RP on needsVacuuming to C on needsVacuuming (_async)
}
