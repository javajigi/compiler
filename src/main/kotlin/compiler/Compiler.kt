package compiler

import ast.ExpressionStatement
import ast.Node
import ast.Program
import ast.expression.InfixExpression
import ast.expression.IntExpression
import code.Instruction
import code.OpCode
import token.TokenType

class Compiler {
    private val instructions = mutableListOf<Instruction>()
    private val constants = mutableListOf<Any>()

    fun compile(node: Node) {
        when (node) {
            is Program -> {
                for (child in node.children()) {
                    compile(child)
                }
            }
            is ExpressionStatement -> {
                compile(node.expression)
                instructions.add(Instruction(OpCode.OpPop))
            }
            is InfixExpression -> {
                compile(node.left)
                compile(node.right)

                val operatorTokenType = node.operator.tokenType
                if (operatorTokenType == TokenType.PLUS) {
                    instructions.add(Instruction(OpCode.OpAdd))
                }
                if (operatorTokenType == TokenType.MINUS) {
                    instructions.add(Instruction(OpCode.OpSub))
                }
                if (operatorTokenType == TokenType.ASTERISK) {
                    instructions.add(Instruction(OpCode.OpMul))
                }
                if (operatorTokenType == TokenType.SLASH) {
                    instructions.add(Instruction(OpCode.OpDiv))
                }
            }
            is IntExpression -> {
                instructions.add(Instruction(OpCode.OpConstant, constants.size))
                constants.add(node.value())
            }
        }
    }

    fun bytecode(): Bytecode = Bytecode(instructions, constants)
}
