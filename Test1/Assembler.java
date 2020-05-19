
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Keith Grable, Matt Pigliavento
 */
public class Assembler {

    /**
     * maps instructions to their formats
     */
    static HashMap<String, String> instructionFormats = new HashMap<String, String>();

    static {
        instructionFormats.put("ADD", "R");
        instructionFormats.put("ADDI", "I");
        instructionFormats.put("ADDIS", "I");
        instructionFormats.put("ADDS", "R");
        instructionFormats.put("AND", "R");
        instructionFormats.put("ANDI", "I");
        instructionFormats.put("ANDIS", "I");
        instructionFormats.put("ANDS", "R");
        instructionFormats.put("B", "B");
        instructionFormats.put("B.EQ", "CB");
        instructionFormats.put("B.NE", "CB");
        instructionFormats.put("B.HS", "CB");
        instructionFormats.put("B.LO", "CB");
        instructionFormats.put("B.MI", "CB");
        instructionFormats.put("B.PL", "CB");
        instructionFormats.put("B.VS", "CB");
        instructionFormats.put("B.VC", "CB");
        instructionFormats.put("B.HI", "CB");
        instructionFormats.put("B.LS", "CB");
        instructionFormats.put("B.GE", "CB");
        instructionFormats.put("B.LT", "CB");
        instructionFormats.put("B.GT", "CB");
        instructionFormats.put("B.LE", "CB");
        instructionFormats.put("B.AL", "CB");
        instructionFormats.put("B.NV", "CB");
        instructionFormats.put("BL", "B");
        instructionFormats.put("BR", "R");
        instructionFormats.put("CBNZ", "CB");
        instructionFormats.put("CBZ", "CB");
        instructionFormats.put("EOR", "R");
        instructionFormats.put("EORI", "I");
        instructionFormats.put("LDUR", "D");
        instructionFormats.put("LSL", "R");
        instructionFormats.put("LSR", "R");
        instructionFormats.put("ASR", "R");
        instructionFormats.put("MOV", "R");
        instructionFormats.put("MUL", "R");
        instructionFormats.put("ORR", "R");
        instructionFormats.put("ORRI", "I");
        instructionFormats.put("STUR", "D");
        instructionFormats.put("SUB", "R");
        instructionFormats.put("SUBI", "I");
        instructionFormats.put("SUBIS", "I");
        instructionFormats.put("SUBS", "R");
    }

    /**
     * maps instructions to their opCodes
     */
    static HashMap<String, String> opcodes = new HashMap<String, String>();

    static {
        opcodes.put("ADD", "10001011000");
        opcodes.put("ADDI", "1001000100");
        opcodes.put("ADDIS", "1011000100");
        opcodes.put("ADDS", "10101011000");
        opcodes.put("AND", "10001010000");
        opcodes.put("ANDI", "1001001000");
        opcodes.put("ANDIS", "1111001000");
        opcodes.put("ANDS", "11101010000");
        opcodes.put("B", "000101");
        opcodes.put("B.", "01010100");
        opcodes.put("BL", "100101");
        opcodes.put("BR", "11010110000");
        opcodes.put("CBNZ", "10110101");
        opcodes.put("CBZ", "10110100");
        opcodes.put("EOR", "11001010000");
        opcodes.put("EORI", "1101001000");
        opcodes.put("LDUR", "11111000010");
        opcodes.put("LSL", "11010011011");
        opcodes.put("LSR", "11010011010");
        opcodes.put("ASR", "10010011010");
        opcodes.put("MOV", "10101010000");
        opcodes.put("MUL", "10011011000");
        opcodes.put("ORR", "10101010000");
        opcodes.put("ORRI", "1011001000");
        opcodes.put("STUR", "11111000000");
        opcodes.put("SUB", "11001011000");
        opcodes.put("SUBI", "1101000100");
        opcodes.put("SUBIS", "1111000100");
        opcodes.put("SUBS", "11101011000");
    }
    
    static HashMap<String, String> conditionals = new HashMap<String, String>();
    
    static {
    	conditionals.put("EQ", "00000");
    	conditionals.put("NE", "00001");
    	conditionals.put("HS", "00010");
    	conditionals.put("LO", "00011");
    	conditionals.put("MI", "00100");
    	conditionals.put("PL", "00101");
    	conditionals.put("VS", "00110");
    	conditionals.put("VC", "00111");
    	conditionals.put("HI", "01000");
    	conditionals.put("LS", "01001");
    	conditionals.put("GE", "01010");
    	conditionals.put("LT", "01011");
    	conditionals.put("GT", "01100");
    	conditionals.put("LE", "01101");
    	conditionals.put("AL", "01111");
    	conditionals.put("NV", "10000");
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(args[0]));

        ArrayList<String> instructions = new ArrayList<String>();

        HashMap<String, Integer> labels = new HashMap<String, Integer>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            instructions.add(line);
        }
        sc.close();

        for (int i = 0; i < instructions.size(); i++) {
            String temp = instructions.get(i);
            int index = temp.indexOf(":");
            if (index != -1) {
                String label = temp.substring(0, index);

                labels.put(label, i);
            }
        }

        for (String element : instructions) {

            String[] arr = element.split("(, )|( )");
            String instruction = (arr[0].contains(":") ? arr[1] : arr[0]);

        }

        System.out.println(iToBinary(new String[]{"SUBI", "XZR", "X9", "#0"}));

    }//end main

    private static String parseOperand(String register) {
        switch (register) {
            case "SP":
                register = "X28";
                break;
            case "FP":
                register = "X29";
                break;
            case "LR":
                register = "X30";
                break;
            case "XZR":
                register = "X31";
                break;
        }

        String number = register.substring(1);
        int num = Integer.parseInt(number);

        return Integer.toBinaryString(num);
    }

    /**
     * Assume instruction is at instruction[0]
     *
     */
    private static String rToBinary(String[] instruction) {

        String opcode = opcodes.get(instruction[0]);

        String rd = parseOperand(instruction[1]);
        rd = pad(rd, 5);

        String rn, rm, shamt;
        if (instruction[3].charAt(0) == '#') {
            rm = "00000";

            rn = parseOperand(instruction[2]);
            rn = pad(rn, 5);

            shamt = parseOperand(instruction[3]);
            shamt = pad(shamt, 6);

        } else {
            rm = parseOperand(instruction[2]);
            rm = pad(rm, 5);

            rn = parseOperand(instruction[3]);
            rn = pad(rn, 5);
            
            shamt = "000000";
        }

        return opcode + " " + rm + " " + shamt + " " + rn + " " + rd;
    }

    private static String iToBinary(String[] instruction) {
        String opcode = opcodes.get(instruction[0]);

        String rd = parseOperand(instruction[1]);
        rd = pad(rd,5);
        
        String rn = parseOperand(instruction[2]);
        rn = pad(rn, 5);
        
        String immediate = parseOperand(instruction[3]);
        immediate = pad(immediate, 12);

        return opcode + " " + immediate + " " + rn + " " + rd;
    }
    
    private static String cbToBinary(String[] instruction, int jumpFrom, int jumpTo) {
    	String opcode = opcodes.get("B.");
    	
    	String cond = instruction[0].substring(2);
    	cond = conditionals.get(cond);
    	
    	int distance = jumpTo - jumpFrom;
    	
    	String jump = Integer.toBinaryString(distance);
    	
    	if (distance < 0) {
    		jump = compress(jump, 19);
    	}
    	else {
    		jump = pad(jump, 19);
    	}
    	
    	return opcode + " " + distance + " " + cond;
    	
    }

    private static String pad(String str, int len) {
        while (str.length() < len) {
            //System.out.println(str + ".length() is " + str.length());
            str = "0" + str;
        }
        return str;
    }
    
    private static String compress(String str, int len) {
    	while (str.length() > len) {
            //System.out.println(str + ".length() is " + str.length());
            str = str.substring(1);
        }
        return str;
    }

}//end class