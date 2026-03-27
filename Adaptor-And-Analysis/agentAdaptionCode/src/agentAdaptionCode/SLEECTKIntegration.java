package agentAdaptionCode;
import circus.robocalc.sleec.*;
import circus.robocalc.sleec.sLEEC.BoolOp;
import circus.robocalc.sleec.sLEEC.RelOp;
import circus.robocalc.sleec.sLEEC.SLEECFactory;
import circus.robocalc.sleec.sLEEC.SLEECPackage;
import workflowspec.WorkflowspecFactory;
import workflowspec.WorkflowspecPackage;

public class SLEECTKIntegration {

	
	public static String addBrackets(String expr, boolean Add) {
		return "(" + expr + ")";
	}
	
	public static String exprToString(circus.robocalc.sleec.sLEEC.MBoolExpr expr) {
		return exprToString(expr,true);
	}
	
	public static String exprToString(circus.robocalc.sleec.sLEEC.MBoolExpr expr,boolean toplevel) {
		if(expr == null) {
			System.out.println("NULL ERROR");
			return null;
		}
		switch(expr) {
		
		case circus.robocalc.sleec.sLEEC.BoolComp x:
			String op = x.getOp().toString().toLowerCase();
			System.out.println(op);
			circus.robocalc.sleec.sLEEC.MBoolExpr left = x.getLeft();
			circus.robocalc.sleec.sLEEC.MBoolExpr right = x.getRight();
			return addBrackets(exprToString(left,false) + " " + op + " " + exprToString(right,false),true);
			
		case circus.robocalc.sleec.sLEEC.RelComp x:
			circus.robocalc.sleec.sLEEC.MBoolExpr Rleft = x.getLeft();
			circus.robocalc.sleec.sLEEC.MBoolExpr Rright = x.getRight();
			String opRel = x.getOp().toString();
			return addBrackets(exprToString(Rleft,false) + " " + opRel + " " + exprToString(Rright,false),true);
			
		case circus.robocalc.sleec.sLEEC.Not x:
			circus.robocalc.sleec.sLEEC.MBoolExpr toNegate = x.getExpr();
			switch(toNegate) {
			case circus.robocalc.sleec.sLEEC.Not next:
				circus.robocalc.sleec.sLEEC.MBoolExpr nextExpr = next.getExpr();
				return exprToString(nextExpr,false);
			default: //No nesting of nots
				return "not" + " " + exprToString(toNegate,false);
			}
			
		case circus.robocalc.sleec.sLEEC.BoolValue x:
			return Boolean.toString(x.isValue());
			
		case circus.robocalc.sleec.sLEEC.Value x:
			return Integer.toString(x.getValue());
			
		case circus.robocalc.sleec.sLEEC.Atom x:
			return "$" + x.getMeasureID();
		
		default:
			System.out.println("ERROR: invalid MBOOLEXPRESSION");
			return "ERROR: invalid MBOOLEXPRESSION";
		}
	}
	
	
	public static String opToRoboSim(String op) {
		op = op.replace("or", "\\/");
		op = op.replace("and","/\\");
		return op;
	}
	
	public static String exprToString(workflowspec.MBoolExpr expr,boolean forRoboSim) {
		return exprToString(expr, true,forRoboSim);
	}
	
	public static String exprToString(workflowspec.MBoolExpr expr,boolean toplevel,boolean forRoboSim) {
		if(expr == null) {
			System.out.println("NULL ERROR");
			return null;
		}
		
		switch(expr) {
		
		case workflowspec.BoolComp x:
			String op = x.getOp().toString().toLowerCase();
			if(forRoboSim) {
				op = opToRoboSim(op);
			}
			workflowspec.MBoolExpr left = x.getLeft();
			workflowspec.MBoolExpr right = x.getRight();
			return addBrackets(exprToString(left,false,forRoboSim) + " " + op + " " + exprToString(right,false,forRoboSim),true);
			
		case workflowspec.RelComp x:
			workflowspec.MBoolExpr Rleft = x.getLeft();
			workflowspec.MBoolExpr Rright = x.getRight();
			String opRel = convOp(x.getOp());
			return addBrackets(exprToString(Rleft,false,forRoboSim) + " " + opRel + " " + exprToString(Rright,false,forRoboSim),true);
			
		case workflowspec.Not x:
			workflowspec.MBoolExpr toNegate = x.getExpr();
			switch(toNegate) {
			case workflowspec.Not next:
				workflowspec.MBoolExpr nextExpr = next.getExpr();
				return exprToString(nextExpr,false,forRoboSim);
			default: //No nesting of nots
				return "not" + " " + exprToString(toNegate,false,forRoboSim);
			}
			
		case workflowspec.BoolValue x:
			return Boolean.toString(x.isValue());
			
		case workflowspec.Value x:
			return Integer.toString(x.getValue());
			
		case workflowspec.Atom x:
			if(forRoboSim) {
				return "$" + x.getMeasureID();
			} else {
				return x.getMeasureID();
			}
		
		default:
			System.out.println("ERROR: invalid MBOOLEXPRESSION");
			return "ERROR: invalid MBOOLEXPRESSION";
		}
	}
	
	public static workflowspec.MBoolExpr not(workflowspec.MBoolExpr expr) {
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
		workflowspec.Not notExpr = factory.createNot();
		
		notExpr.setExpr(expr);
		return notExpr;
		
	}
	public static circus.robocalc.sleec.sLEEC.MBoolExpr not(circus.robocalc.sleec.sLEEC.MBoolExpr expr) {
		SLEECFactory factory = SLEECFactory.eINSTANCE;
		circus.robocalc.sleec.sLEEC.Not notExpr = factory.createNot();
		notExpr.setExpr(expr);
		return notExpr;
	}

	public static workflowspec.MBoolExpr convExpr(circus.robocalc.sleec.sLEEC.MBoolExpr expr){
		
		if(expr == null) {
			System.out.println("NULL ERROR");
			return null;
		}
		
		WorkflowspecFactory factory = WorkflowspecFactory.eINSTANCE;
	
		switch(expr) {
	
		case circus.robocalc.sleec.sLEEC.BoolComp x:
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
		
		case circus.robocalc.sleec.sLEEC.RelComp x:
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
				newOp1 = null;				}
			
			RelComp.setOp(newOp1);
			RelComp.setLeft(convLeft1);
			RelComp.setRight(convRight1);
			
			return RelComp;
			
		case circus.robocalc.sleec.sLEEC.Not x:
			
			circus.robocalc.sleec.sLEEC.MBoolExpr toNegate = (circus.robocalc.sleec.sLEEC.MBoolExpr) x.getExpr();
			workflowspec.MBoolExpr convExpr = convExpr(toNegate);
			
			workflowspec.Not negation = factory.createNot();
			negation.setExpr(convExpr);
			return negation;
			
		case circus.robocalc.sleec.sLEEC.BoolValue x:		
			workflowspec.BoolValue boolValue = factory.createBoolValue();
			if(x.isValue()){
				boolValue.setValue(true);
			} else if (!x.isValue()) {
				boolValue.setValue(false);
			}else {
				System.out.println("Value boolean not matching");
			}
			
			return boolValue;
			
		
		case circus.robocalc.sleec.sLEEC.Value x:
			
			int value = x.getValue();
			workflowspec.Value newValue = factory.createValue();
			newValue.setValue(value);
			return newValue;
		
		case circus.robocalc.sleec.sLEEC.Atom x:
			String ID = x.getMeasureID();
			workflowspec.Atom newAtom = factory.createAtom();
			newAtom.setMeasureID(ID);
			return newAtom;

		default:
			System.out.println("Error: no matching case whilst converting expression");
			workflowspec.MBoolExpr error = factory.createMBoolExpr();
			return error;
		}
	}
		
	public static String convOp(workflowspec.RelOp op) {
		if(op.equals(workflowspec.RelOp.EQUAL)){
			return "=";
		} else if (op.equals(workflowspec.RelOp.GREATER_EQUAL)) {
			return ">=";
		} else if (op.equals(workflowspec.RelOp.GREATER_THAN)) {
			return ">";
		} else if (op.equals(workflowspec.RelOp.LESS_EQUAL)) {
			return "<=";
		} else if (op.equals(workflowspec.RelOp.LESS_THAN)) {
			return "<";
		} else if (op.equals(workflowspec.RelOp.NOT_EQUAL)) {
			return "<>";
		} else {
			//Should never run
			System.out.println("Workflow op conversion error");
			return "";
		}
	}
}
	
	
		
