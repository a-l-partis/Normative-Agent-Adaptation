interface TasksStartI {
	SmallTaskStart()
}
interface TasksEndI {
	event SmallTaskEnd
}
interface GuardsI {
	event smallguard1 : boolean
	event unmappedBumperCount : real
	event smallguard2 : boolean
}
module M {
	cycleDef cycle == 1
	robotic platform RP {
		uses TasksEndI uses GuardsI provides TasksStartI
	}
	controller C {
		requires TasksStartI uses GuardsI uses TasksEndI cycleDef true
		stm wfSTM {
			var localsmallguard2 : boolean
			var localsmallguard1 : boolean
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
				condition not $smallguard1 ? localsmallguard1
			}
			transition t2 {
				from s1
				to x0
				condition $ smallguard1 ? localsmallguard1
			}
			state x0 {}
			transition t3 {
				from x0
				to x0
				exec
				condition not $smallguard2 ? localsmallguard2
			}
			transition t4 {
				from x0
				to x1
				condition $ smallguard2 ? localsmallguard2
			}
			state s5 {}
			state x1 {}
			transition t5 {
				from x1
				to s5
			}
			transition t6 {
				from s5
				to s6
				condition (localsmallguard2 /\ localsmallguard1)
			}
			state s8 {}
			state s6 {
				entry $ SmallTaskStart() ; exec
			}
			state x2 {}
			transition t8 {
				from x2
				to x2
				exec
				condition not $SmallTaskEnd
			}
			transition t9 {
				from s6
				to x2
			}
			transition t10 {
				from x2
				to s8
				exec
				condition $SmallTaskEnd
			}
			transition t12 {
				from s8
				to x5
				exec			}
			state x5 {}
			transition t13 {
				from x5
				to x5
				exec
				condition not $smallguard1 ? localsmallguard1
			}
			transition t14 {
				from x5
				to x6
				condition $ smallguard1 ? localsmallguard1
			}
			state x6 {}
			transition t15 {
				from x6
				to x6
				exec
				condition not $smallguard2 ? localsmallguard2
			}
			transition t16 {
				from x6
				to x7
				condition $ smallguard2 ? localsmallguard2
			}
			state x7 {}
			transition t17 {
				from x7
				to s5
			}
			transition t18 {
				from s5
				to s2
				condition not (localsmallguard2 /\ localsmallguard1)
			}
		}
		connection C on SmallTaskEnd to wfSTM on SmallTaskEnd (_async)
		connection C on smallguard1 to wfSTM on smallguard1 (_async)
		connection C on unmappedBumperCount to wfSTM on unmappedBumperCount (_async)
		connection C on smallguard2 to wfSTM on smallguard2 (_async)
	}
	connection RP on SmallTaskEnd to C on SmallTaskEnd (_async)
	connection RP on smallguard1 to C on smallguard1 (_async)
	connection RP on unmappedBumperCount to C on unmappedBumperCount (_async)
	connection RP on smallguard2 to C on smallguard2 (_async)
}
