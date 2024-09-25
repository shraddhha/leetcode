class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        prefix_map = {}

        for word in words:
            temp = ''
            for char in word:
                temp += char
                if prefix_map.get(temp):
                    prefix_map[temp] += 1
                else:
                    prefix_map[temp] = 1
            
        output = []

        for word in words:
            temp = ''
            val = 0
            for char in word:
                temp += char
                val += prefix_map[temp]
            output.append(val)
        
        return output
