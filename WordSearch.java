// You are given a 2D array of characters, and a target string. Return whether or not the word target word exists in the matrix. Unlike a standard word search, the word must be either going left-to-right, or top-to-bottom in the matrix.

// Example:
// [['F', 'A', 'C', 'I'],
//  ['O', 'B', 'Q', 'P'],
//  ['A', 'N', 'O', 'B'],
//  ['M', 'A', 'S', 'S']]

// Given this matrix, and the target word FOAM, you should return true, as it can be found going up-to-down in the first column.


public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = {
            {'F','A','C','I'},
            {'O','B','Q','P'},
            {'A','N','O','B'},
            {'M','A','S','S'}
        };

        String checkWord = "FOAM";
        System.out.println("Does "+checkWord+" exist in matrix\n"+matrixAsString(matrix)+"? => "+check(matrix,checkWord));
    }    

    //This solution assumes the 2D matrix is of equal height, width and that the height and width
    static boolean check(char[][] matrix,String check){
        return checkHorizontally(matrix,check) || checkVertically(matrix, check);
    }

    static boolean checkVertically(char[][] matrix, String check){
        char[] firstRow = matrix[0];
        if(check.length() > firstRow.length)
            return false;

        //because the word length might be less than the column height
        int possibleMatchesInColumn = (firstRow.length - check.length()) + 1;

        for (int i = 0; i < firstRow.length; i++) {//iterate through all columns
            for (int rowIndexStart = 0; rowIndexStart < possibleMatchesInColumn; rowIndexStart++) {
                boolean match = true;
                for (int j = 0; j < check.length(); j++) {
                    match &= check.charAt(j) == matrix[rowIndexStart + j][i];
                    if(!match)
                        break;
                }
                if(match)
                    return true;
            }
        }
        return false;
    }

    static boolean checkHorizontally(char[][] matrix, String check){
        char[] firstRow = matrix[0];
        if(check.length() > firstRow.length)
            return false;
        
        //because the word length might be less than the width of a column height
        int possibleMatchesInRow = (firstRow.length - check.length()) + 1;
        
        for(char[] row: matrix){
            for (int columnIndexStart = 0; columnIndexStart < possibleMatchesInRow; columnIndexStart++) {
                boolean match = true;//assume the word is in the row; 
                //just looking for proof it isn't
                for (int j = 0; j < check.length(); j++) {
                    match &= check.charAt(j) == row[columnIndexStart+j];
                    if(!match)
                        break;
                }
                if(match)
                    return true;
            }
        }
        
        return false;
    }

    static String matrixAsString(char[][] matrx){
        StringBuilder string = new StringBuilder();
        for(char[] row: matrx){
            for(char a: row){
                string.append(a).append(' ');
            }
            string.append("\n");
        }
        return string.toString();
    }
}