class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS = len(board)
        COLS = len(board[0])

        def check(r, c):
            if r<0 or c<0 or r==ROWS or c==COLS or board[r][c] != "O":
                return
            board[r][c] = "T"
            check(r+1, c)
            check(r-1, c)
            check(r, c+1)
            check(r, c-1)

        # Check edges
        # Check first and last rows
        for c in range(COLS):
            check(0, c)
            check(ROWS - 1, c)
        
        # Check first and last cols
        for r in range(ROWS):
            check(r, 0)
            check(r, COLS - 1)
        
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "T":
                    board[r][c] = "O"
                else:
                    board[r][c] = "X"

