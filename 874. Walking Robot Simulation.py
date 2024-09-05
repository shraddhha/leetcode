class Solution(object):
    def robotSim(self, commands, obstacles):
        """
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
       
    # Direction vectors: North, East, South, West
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        direction_index = 0  # Start facing North
        
        # Starting position
        x, y = 0, 0
        
        # Convert obstacles to a set of tuples for quick lookup
        obstacle_set = set(map(tuple, obstacles))
        
        # To track the maximum Euclidean distance squared
        max_distance_squared = 0
        
        # Process each command
        for command in commands:
            if command == -2:  # Turn left
                direction_index = (direction_index - 1) % 4
            elif command == -1:  # Turn right
                direction_index = (direction_index + 1) % 4
            else:
                # Move forward 'command' steps
                dx, dy = directions[direction_index]
                for _ in range(command):
                    # Move one step in the current direction
                    if (x + dx, y + dy) not in obstacle_set:
                        x += dx
                        y += dy
                        # Update the maximum Euclidean distance squared
                        max_distance_squared = max(max_distance_squared, x**2 + y**2)
                    else:
                        # Stop if there's an obstacle
                        break
    
        return max_distance_squared

        
