class Solution(object):
    def maxBottlesDrunk(self, num_bottles, num_exchange):
        """
        :type num_bottles: int
        :type num_exchange: int
        :rtype: int
        """
        
        drunk = num_bottles
        empty = num_bottles

        while empty >= num_exchange:
            empty -= num_exchange
            drunk +=1
            empty +=1
            num_exchange +=1
        
        return drunk