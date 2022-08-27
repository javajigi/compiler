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
            }
            is InfixExpression -> {
                compile(node.left)
                compile(node.right)

                if (node.operator.tokenType == TokenType.PLUS) {
                    instructions.add(Instruction(OpCode.OpAdd))
                }
            }
            is IntExpression -> {
                instructions.add(Instruction(OpCode.OpConstant, instructions.size))
                constants.add(node.value())
            }
        }
    }

    fun bytecode(): Bytecode = Bytecode(instructions, constants)
}
