
const EMPTY: i8 = 0;
const GUARD: i8 = 1;
const WALL: i8 = 2;
const GUARDED: i8 = 3;
impl Solution {
    pub fn count_unguarded(m: i32, n: i32, guards: Vec<Vec<i32>>, walls: Vec<Vec<i32>>) -> i32 {
        let rows = m as usize;
        let cols = n as usize;

        // 1. Initialize the grid: A 2D vector (Vec<Vec<i8>>) initialized to EMPTY (0).
        let mut grid: Vec<Vec<i8>> = vec![vec![EMPTY; cols]; rows];

        // 2. Place Walls (2) and Guards (1) on the grid.
        // Walls are placed first.
        for wall in walls {
            let r = wall[0] as usize;
            let c = wall[1] as usize;
            grid[r][c] = WALL;
        }

        // Guards are placed second. We borrow the list of guards to use it in the next step.
        // This loop uses a reference (&guards), so the vector is not moved/consumed here.
        for guard in &guards {
            let r = guard[0] as usize;
            let c = guard[1] as usize;
            grid[r][c] = GUARD;
        }

        // Directions: (dr, dc) for row-delta and column-delta.
        // Corresponds to (Up, Down, Left, Right)
        let directions = vec![
            (-1, 0), // North
            (1, 0),  // South
            (0, -1), // West
            (0, 1),  // East
        ];

        // 3. Ray Casting: For each guard, simulate their line of sight.
        // FIX: We must use a reference (&guards) here as well, since the vector is still needed.
        for guard in &guards {
            let start_r = guard[0];
            let start_c = guard[1];

            // Check sight in all four directions from the current guard
            for &(dr, dc) in directions.iter() {
                let mut r = start_r;
                let mut c = start_c;

                // Loop outwards in the current direction until a boundary or an obstacle is hit
                loop {
                    r += dr;
                    c += dc;

                    // Boundary check: If outside the grid, stop this ray cast.
                    // We use i32 for r and c to safely check bounds before casting to usize.
                    if r < 0 || r >= m || c < 0 || c >= n {
                        break;
                    }

                    let curr_r = r as usize;
                    let curr_c = c as usize;
                    let cell_state = grid[curr_r][curr_c];

                    // Obstruction check: If we hit a Wall (2) or another Guard (1), stop.
                    if cell_state == WALL || cell_state == GUARD {
                        break;
                    }

                    // Mark as Guarded (3) only if it was an EMPTY (0) cell.
                    // If it's already 3 (guarded by another ray), we leave it as 3 and continue.
                    if cell_state == EMPTY {
                        grid[curr_r][curr_c] = GUARDED;
                    }
                    
                    // The loop automatically continues to the next cell in this direction
                }
            }
        }

        // 4. Count Unguarded Cells: Count all cells that are still EMPTY (0).
        let mut unguarded_count = 0;
        for row in grid.iter() {
            for &cell in row.iter() {
                if cell == EMPTY {
                    unguarded_count += 1;
                }
            }
        }

        unguarded_count
    
    }
}