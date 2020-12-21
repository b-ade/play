// Hi, here's your problem today. This problem was recently asked by Uber:

// Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings. 

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
// An input string is valid if:
// - Open brackets are closed by the same type of brackets.
// - Open brackets are closed in the correct order.
// - Note that an empty string is also considered valid.

public class FakeCompiler {

    static char openParenthesis = '(',closingParenthesis = ')', openSquareBracket = '[', closingSquareBracket = ']', openCurlyBracket = '{', closingCurlyBracket = '}';

    static int contextParenthesis = 1, contextSquareBracket = 2, contextCurlyBracket = 3;

   public static void main(String[] args){
       for (String string : args) {
           System.out.println(string+" => "+isValid(string));
       }
    } 

    /**
     * A Scope is an instance of an opened '(','[', or '{' which must be closed
     * It allows for layers/levels of nesting as in the case of (({})) for example
     * The logic in the {@link #onRead(char)} ensures the rules are followed and returns a reference to the current scope reached based on the input that is read.
     */
    static class Scope{
        Scope inner;
        Scope outer;
        Scope next;
        Scope previous;

        char lastRead;
        boolean isClosed;

        public Scope(char currentChar){
            this.lastRead = currentChar;
        }

        /**
         * Attempt to parse each character in the sequence while adjusting scope arcordingly
         * @param character the next character in the sequence
         * @return the current scope of the 'program' or null if it would result in an invalid scope
         */
        public Scope onRead(char character){
            //opening a new context
            if(getContext(character) != 0){
                //opening a new context after one was closed
                if(isClosed){
                    next = new Scope(character);
                    next.previous = this;
                    return next;
                }else{ //opening a new context inside existing
                    inner = new Scope(character);//create new context
                    inner.outer = this;//remember the owning context
                    return inner;//enter the newly created inner context
                }
            } 


            //attempting a close
            int lastContext = getContext(this.lastRead);
            
            //can't close without an open
            if(isClosed){
                return null;
            }

            if(lastContext == contextParenthesis && character == closingParenthesis){
                isClosed = true;
            }else if(lastContext == contextSquareBracket && character == closingSquareBracket){
                isClosed = true;
            }else if(lastContext == contextCurlyBracket && character == closingCurlyBracket){
                isClosed = true;
            }

            //if closing context...
            if(isClosed){
                if(outer != null)//...and context is enclosed by another
                    return outer;//return focus to outer context
                return this;
            }

            //an illegal closing was attempted
            return null;
        }
    } 

    /**
     * Iteratively reach characters an check that each read is valid with regard to the previous
     * @param input
     * @return
     */
    static boolean isValid(String input){
        if(input.length() > 0){
            char firstChar = input.charAt(0);
            int currentContext = getContext(firstChar);

            if(currentContext == 0)
                return false;
    
            Scope current = new Scope(firstChar);
            for(int i = 1; i < input.length(); i++){
                Scope result = current.onRead(input.charAt(i));
                if(result == null)
                    return false;
                current = result;
            }

            return current.isClosed;//ensure the last focused scope is closed
        }

        return true;
    }

    private static int getContext(char character){
        return character == openParenthesis ? contextParenthesis :
            character == openSquareBracket ? contextSquareBracket : 
            character == openCurlyBracket ? contextCurlyBracket : 0;
    }
}