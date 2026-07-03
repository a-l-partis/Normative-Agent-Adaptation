package agentAdaptionCode;
import java.util.ArrayList;

import circus.robocalc.sleec.sLEEC.BoolOp;
import circus.robocalc.sleec.sLEEC.RelOp;
import workflowspec.WorkflowspecFactory;

public class SLEECTKIntegration {

    public static String addBrackets(String expr, boolean Add) {
        return "(" + expr + ")";
    }

    public static String exprToString(circus.robocalc.sleec.sLEEC.MBoolExpr expr) {
        return exprToString(expr, true);
    }

    public static String exprToString(circus.robocalc.sleec.sLEEC.MBoolExpr expr, boolean toplevel) {
        if (expr == null) {
            System.out.println("NULL ERROR");
            return null;
        }

        if (expr instanceof circus.robocalc.sleec.sLEEC.BoolComp) {
            circus.robocalc.sleec.sLEEC.BoolComp x = (circus.robocalc.sleec.sLEEC.BoolComp) expr;
            String op = x.getOp().toString().toLowerCase();
            circus.robocalc.sleec.sLEEC.MBoolExpr left = x.getLeft();
            circus.robocalc.sleec.sLEEC.MBoolExpr right = x.getRight();
            return addBrackets(exprToString(left, false) + " " + op + " " + exprToString(right, false), true);

        } else if (expr instanceof circus.robocalc.sleec.sLEEC.RelComp) {
            circus.robocalc.sleec.sLEEC.RelComp x = (circus.robocalc.sleec.sLEEC.RelComp) expr;
            circus.robocalc.sleec.sLEEC.MBoolExpr Rleft = x.getLeft();
            circus.robocalc.sleec.sLEEC.MBoolExpr Rright = x.getRight();
            String opRel = x.getOp().toString();
            return addBrackets(exprToString(Rleft, false) + " " + opRel + " " + exprToString(Rright, false), true);

        } else if (expr instanceof circus.robocalc.sleec.sLEEC.Not) {
            circus.robocalc.sleec.sLEEC.Not x = (circus.robocalc.sleec.sLEEC.Not) expr;
            circus.robocalc.sleec.sLEEC.MBoolExpr y = x.getExpr();

            if (y instanceof circus.robocalc.sleec.sLEEC.Not) {
                circus.robocalc.sleec.sLEEC.Not noty = (circus.robocalc.sleec.sLEEC.Not) y;
                return exprToString(noty.getExpr(),false);
            } else {
                // No nesting of nots
                return "not" + " " + exprToString(y, false);
            }

        } else if (expr instanceof circus.robocalc.sleec.sLEEC.BoolValue) {
            circus.robocalc.sleec.sLEEC.BoolValue x = (circus.robocalc.sleec.sLEEC.BoolValue) expr;
            return Boolean.toString(x.isValue());

        } else if (expr instanceof circus.robocalc.sleec.sLEEC.Value) {
            circus.robocalc.sleec.sLEEC.Value x = (circus.robocalc.sleec.sLEEC.Value) expr;
            return Integer.toString(x.getValue());

        } else if (expr instanceof circus.robocalc.sleec.sLEEC.Atom) {
            circus.robocalc.sleec.sLEEC.Atom x = (circus.robocalc.sleec.sLEEC.Atom) expr;
            return "$" + x.getMeasureID();

        } else {
            System.out.println("ERROR: invalid MBOOLEXPRESSION");
            return "ERROR: invalid MBOOLEXPRESSION";
        }
    }

    public static String opToRoboSim(String op) {
        op = op.replace("or", "\\/");
        op = op.replace("and", "/\\");
        return op;
    }

    public static String exprToString(workflowspec.MBoolExpr expr, boolean forRoboSim,ArrayList<String> measureList) {
        return exprToString(expr, true, forRoboSim,measureList);
    }
    
    
    public static ArrayList<String> extractGuards(workflowspec.MBoolExpr expr) {
    	ArrayList <String> guards = new ArrayList<String>();
        if (expr == null) {
            System.out.println("NULL ERROR");
            return null;
        }

        if (expr instanceof workflowspec.BoolComp) {
        	workflowspec.BoolComp x = (workflowspec.BoolComp) expr;
        	workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            
            if (left instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) left;
            	guards.add(atom.getMeasureID());
            }
            
            if (right instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) right;
            	guards.add(atom.getMeasureID());
            }
        	
            return guards;
            
        } else if (expr instanceof workflowspec.RelComp) {
        	workflowspec.RelComp x = (workflowspec.RelComp) expr;
        	workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            
            if (left instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) left;
            	guards.add(atom.getMeasureID());
            }
            
            if (right instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) right;
            	guards.add(atom.getMeasureID());
            }
            
            return guards;
        	
        } else if (expr instanceof workflowspec.Not) {
        	workflowspec.Not x = (workflowspec.Not) expr;
        	workflowspec.MBoolExpr y = x.getExpr();
        	
        	if (y instanceof workflowspec.Atom) {
        		
        		workflowspec.Atom atom = (workflowspec.Atom) y;
            	guards.add(atom.getMeasureID());

        	}
        	
        	
        	if (y instanceof workflowspec.Not) {
        		workflowspec.Not not = (workflowspec.Not) y;
        		guards.addAll(extractGuards(y));
            }
        	
        	else {
        		guards.addAll(extractGuards(y));
        	}
        	
        	return guards;

        } else if (expr instanceof workflowspec.BoolValue) {
        	return guards;

        } else if (expr instanceof workflowspec.Value) {
        	return guards;

        } else if (expr instanceof workflowspec.Atom) {
        	workflowspec.Atom x = (workflowspec.Atom) expr;
            guards.add(x.getMeasureID());
            return guards;

        } else {
            System.out.println("ERROR: invalid MBOOLEXPRESSION");
            guards.add("ERROR: invalid MBOOLEXPRESSION");
            return guards;
        }
    }


    public static ArrayList<GuardAndType> extractGuardsAndTypes(workflowspec.MBoolExpr expr,boolean insideRelComp) {
    	ArrayList <GuardAndType> guards = new ArrayList<GuardAndType>();
        if (expr == null) {
            System.out.println("NULL ERROR");
            return null;
        }

        if (expr instanceof workflowspec.BoolComp) {
        	
        	workflowspec.BoolComp x = (workflowspec.BoolComp) expr;
        	workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            
            if (left instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) left;
            	
            	guards.add(new GuardAndType(atom.getMeasureID(),"bool"));
            } else {
            	guards.addAll(extractGuardsAndTypes(left,insideRelComp));
            }
            
            if (right instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) right;
            	guards.add(new GuardAndType(atom.getMeasureID(),"bool"));
            }else {
            	guards.addAll(extractGuardsAndTypes(right,insideRelComp));
            }
            
        	
            return guards;
            
        } else if (expr instanceof workflowspec.RelComp) {
        	workflowspec.RelComp x = (workflowspec.RelComp) expr;
        	workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            
            if (left instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) left;
            	guards.add(new GuardAndType(atom.getMeasureID(),"real"));
            }else {
            	guards.addAll(extractGuardsAndTypes(left,true));
            }
            
            if (right instanceof workflowspec.Atom) {
            	workflowspec.Atom atom = (workflowspec.Atom) right;
            	guards.add(new GuardAndType(atom.getMeasureID(),"real"));
            }else {
            	guards.addAll(extractGuardsAndTypes(right,true));
            }

            return guards;
        	
        } else if (expr instanceof workflowspec.Not) {
        	workflowspec.Not x = (workflowspec.Not) expr;
        	workflowspec.MBoolExpr y = x.getExpr();

        	guards.addAll(extractGuardsAndTypes(y,insideRelComp));
        	return guards;

        } else if (expr instanceof workflowspec.BoolValue) {
        	return guards;

        } else if (expr instanceof workflowspec.Value) {
        	return guards;

        } else if (expr instanceof workflowspec.Atom) {
        	workflowspec.Atom x = (workflowspec.Atom) expr;
        	boolean realMeasure = insideRelComp;
    		if(realMeasure) {
    			guards.add(new GuardAndType(x.getMeasureID(),"real"));
    		} else {
    			guards.add(new GuardAndType(x.getMeasureID(),"bool"));
    		}
    		return guards;

        } else {
            System.out.println("ERROR: invalid MBOOLEXPRESSION");
            return guards;
        }
    }
    
    
    
    public static workflowspec.MBoolExpr not(workflowspec.MBoolExpr expr) {
        WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
        workflowspec.Not notExpr = factory.createNot();

        notExpr.setExpr(expr);
        return notExpr;

    }

    public static String exprToString(workflowspec.MBoolExpr expr, boolean toplevel, boolean forRoboSim,ArrayList<String> measureList) {
        if (expr == null) {
            System.out.println("NULL ERROR");
            return null;
        }

        if (expr instanceof workflowspec.BoolComp) {
        	workflowspec.BoolComp x = (workflowspec.BoolComp) expr;
            String op = x.getOp().toString().toLowerCase();
            if (forRoboSim) {
                op = opToRoboSim(op);
            }
            workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            return addBrackets(exprToString(left, false, forRoboSim,measureList) + " " + op + " " + exprToString(right, false, forRoboSim,measureList), true);

        } else if (expr instanceof workflowspec.RelComp) {
        	workflowspec.RelComp x = (workflowspec.RelComp) expr;
        	workflowspec.MBoolExpr Rleft = x.getLeft();
        	workflowspec.MBoolExpr Rright = x.getRight();
            String opRel = convOp(x.getOp());
            return addBrackets(exprToString(Rleft, false, forRoboSim,measureList) + " " + opRel + " " + exprToString(Rright, false, forRoboSim,measureList), true);

        } else if (expr instanceof workflowspec.Not) {
        	workflowspec.Not x = (workflowspec.Not) expr;
        	workflowspec.MBoolExpr y = x.getExpr();
        	if (y instanceof workflowspec.Not) {
        		//Double nots
        		workflowspec.Not noty = (workflowspec.Not) y;
        		return exprToString(noty.getExpr(),false,forRoboSim,measureList);

            } else {
                // No nesting of nots
                return "not " + exprToString(y, false, forRoboSim,measureList);
            }

        } else if (expr instanceof workflowspec.BoolValue) {
        	workflowspec.BoolValue x = (workflowspec.BoolValue) expr;
            return Boolean.toString(x.isValue());

        } else if (expr instanceof workflowspec.Value) {
        	workflowspec.Value x = (workflowspec.Value) expr;
            return Integer.toString(x.getValue());

        } else if (expr instanceof workflowspec.Atom) {
        	workflowspec.Atom x = (workflowspec.Atom) expr;
        	if (measureList.contains(x.getMeasureID())) {
        		return "local" + x.getMeasureID();
        	} else if (forRoboSim) {
                return "$" + x.getMeasureID();
            } else {
                return x.getMeasureID();
            }

        } else {
            System.out.println("ERROR: invalid MBOOLEXPRESSION");
            return "ERROR: invalid MBOOLEXPRESSION";
        }
    }
    

    public static ArrayList<String> getRealGuards(workflowspec.MBoolExpr expr,boolean inRelComp) {
    	ArrayList<String> realGuards = new ArrayList<String>();
        if (expr == null) {
            System.out.println("NULL ERROR");

        }

        if (expr instanceof workflowspec.BoolComp) {
        	workflowspec.BoolComp x = (workflowspec.BoolComp) expr;

            workflowspec.MBoolExpr left = x.getLeft();
            workflowspec.MBoolExpr right = x.getRight();
            realGuards.addAll(getRealGuards(left,inRelComp));
            realGuards.addAll(getRealGuards(right,inRelComp));
            
            return realGuards;
            
        } else if (expr instanceof workflowspec.RelComp) {
        	workflowspec.RelComp z = (workflowspec.RelComp) expr;

            workflowspec.MBoolExpr leftz = z.getLeft();
            workflowspec.MBoolExpr rightz = z.getRight();
            realGuards.addAll(getRealGuards(leftz,true));
            realGuards.addAll(getRealGuards(rightz,true));
            return realGuards;
        
        } else if (expr instanceof workflowspec.Not) {
        	workflowspec.Not f = (workflowspec.Not) expr;
        	workflowspec.MBoolExpr y = f.getExpr();
        	realGuards.addAll(getRealGuards(y,inRelComp));
        	return realGuards;

        } else if (expr instanceof workflowspec.BoolValue) {
        	return new ArrayList<String>();
        } else if (expr instanceof workflowspec.Value) {
        	return new ArrayList<String>();

        } else if (expr instanceof workflowspec.Atom) {
        	workflowspec.Atom a = (workflowspec.Atom) expr;
        	realGuards.add(a.getMeasureID());

        	return realGuards;
        	
        } else {
            System.out.println("ERROR: invalid MBOOLEXPRESSION");
            return new ArrayList<String>();
        }
    }



    public static String convOp(workflowspec.RelOp op) {
        if (op.equals(workflowspec.RelOp.EQUAL)) {
            return "==";
        } else if (op.equals(workflowspec.RelOp.GREATER_EQUAL)) {
            return ">=";
        } else if (op.equals(workflowspec.RelOp.GREATER_THAN)) {
            return ">";
        } else if (op.equals(workflowspec.RelOp.LESS_EQUAL)) {
            return "<=";
        } else if (op.equals(workflowspec.RelOp.LESS_THAN)) {
            return "<";
        } else if (op.equals(workflowspec.RelOp.NOT_EQUAL)) {
            return "!=";
        } else {
            // Should never run
            System.out.println("Workflow op conversion error");
            return "";
        }
    }


public static workflowspec.MBoolExpr convExpr(circus.robocalc.sleec.sLEEC.MBoolExpr expr){
    
    if(expr == null) {
        System.out.println("NULL ERROR");
        return null;
    }
    
    WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;

    if (expr instanceof circus.robocalc.sleec.sLEEC.BoolComp) {
        circus.robocalc.sleec.sLEEC.BoolComp x = (circus.robocalc.sleec.sLEEC.BoolComp) expr;

        circus.robocalc.sleec.sLEEC.BoolOp op = x.getOp();
        circus.robocalc.sleec.sLEEC.MBoolExpr left = x.getLeft();
        circus.robocalc.sleec.sLEEC.MBoolExpr right = x.getRight();

        workflowspec.MBoolExpr convLeft = convExpr(left);
        workflowspec.MBoolExpr convRight = convExpr(right);
        
        workflowspec.BoolComp boolComp = factory.createBoolComp();
        workflowspec.BoolOp newOp;
        if(op.equals(BoolOp.AND)) {
            newOp = workflowspec.BoolOp.AND;
        } else if(op.equals(BoolOp.OR)) {
            newOp = workflowspec.BoolOp.OR;
        } else {
            System.out.println("ERROR: neither operation");
            newOp = null;
        }
        
        boolComp.setOp(newOp);
        boolComp.setLeft(convLeft);
        boolComp.setRight(convRight);
        
        return boolComp;
    }

    else if (expr instanceof circus.robocalc.sleec.sLEEC.RelComp) {
        circus.robocalc.sleec.sLEEC.RelComp x = (circus.robocalc.sleec.sLEEC.RelComp) expr;

        circus.robocalc.sleec.sLEEC.RelOp op1 = x.getOp();
        circus.robocalc.sleec.sLEEC.MBoolExpr left1 = x.getLeft();
        circus.robocalc.sleec.sLEEC.MBoolExpr right1 = x.getRight();
        
        workflowspec.MBoolExpr convLeft1 = convExpr(left1);
        workflowspec.MBoolExpr convRight1 = convExpr(right1);
        
        workflowspec.RelComp RelComp = factory.createRelComp();
        workflowspec.RelOp newOp1;
    
        if(op1.equals(RelOp.EQUAL)) {
            newOp1 = workflowspec.RelOp.EQUAL;
        } else if(op1.equals(RelOp.GREATER_EQUAL)) {
            newOp1 = workflowspec.RelOp.GREATER_EQUAL;
        }else if(op1.equals(RelOp.GREATER_THAN)) {
            newOp1 = workflowspec.RelOp.GREATER_THAN;
        }else if (op1.equals(RelOp.LESS_EQUAL)) {
            newOp1 = workflowspec.RelOp.LESS_EQUAL;
        } else if (op1.equals(RelOp.LESS_THAN)) {
            newOp1 = workflowspec.RelOp.LESS_THAN;
        } else if(op1.equals(RelOp.NOT_EQUAL)) {
            newOp1 = workflowspec.RelOp.NOT_EQUAL;        
        } else {
            System.out.println("ERROR: neither operation");
            newOp1 = null;                }
        
        RelComp.setOp(newOp1);
        RelComp.setLeft(convLeft1);
        RelComp.setRight(convRight1);
        
        
        return RelComp;
    }

    else if (expr instanceof circus.robocalc.sleec.sLEEC.Not) {
        circus.robocalc.sleec.sLEEC.Not x = (circus.robocalc.sleec.sLEEC.Not) expr;

        circus.robocalc.sleec.sLEEC.MBoolExpr toNegate = (circus.robocalc.sleec.sLEEC.MBoolExpr) x.getExpr();
        workflowspec.MBoolExpr convExpr = convExpr(toNegate);
        
        workflowspec.Not negation = factory.createNot();
        negation.setExpr(convExpr);
        return negation;
    }

    else if (expr instanceof circus.robocalc.sleec.sLEEC.BoolValue) {
        circus.robocalc.sleec.sLEEC.BoolValue x = (circus.robocalc.sleec.sLEEC.BoolValue) expr;

        workflowspec.BoolValue boolValue = factory.createBoolValue();
        if(x.isValue()){
            boolValue.setValue(true);
        } else if (!x.isValue()) {
            boolValue.setValue(false);
        }else {
            System.out.println("Value boolean not matching");
        }
        
        return boolValue;
    }

    else if (expr instanceof circus.robocalc.sleec.sLEEC.Value) {
        circus.robocalc.sleec.sLEEC.Value x = (circus.robocalc.sleec.sLEEC.Value) expr;

        int value = x.getValue();
        workflowspec.Value newValue = factory.createValue();
        newValue.setValue(value);
        return newValue;
    }

    else if (expr instanceof circus.robocalc.sleec.sLEEC.Atom) {
        circus.robocalc.sleec.sLEEC.Atom x = (circus.robocalc.sleec.sLEEC.Atom) expr;

        String ID = x.getMeasureID();
        workflowspec.Atom newAtom = factory.createAtom();
        newAtom.setMeasureID(ID);
        return newAtom;
    }

    else {
        System.out.println("Error: no matching case whilst converting expression");
        workflowspec.MBoolExpr error = factory.createMBoolExpr();
        return error;
    }
}

	static class GuardAndType {
		public String guard;
		public String type;
	
		public GuardAndType(String first, String second) {
			this.guard = first;
			this.type = second;
		}
	
	}
}

