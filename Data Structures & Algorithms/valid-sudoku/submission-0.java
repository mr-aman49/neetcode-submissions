class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i =0; i<9;i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int row = 0;row <9;row++){
            for(int col =0; col<9;col++){
                char num = board[row][col];
                if(num == '.'){
                    continue;
                }
                if(!rows[row].add(num)){
                    return false;
                }
                if(!columns[col].add(num)){
                    return false;
                }
                int boxIndex = (row/3)*3 + (col/3);
                if(!boxes[boxIndex].add(num)){
                    return false;
                }
            }
        }
        return true;
    }
}
