class Solution(object):
    def numWaterBottles(self, num_bottles, num_exchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        
        empty_bottles = num_bottles
        total = num_bottles

        while empty_bottles >= num_exchange:
            q = empty_bottles // num_exchange
            r = empty_bottles % num_exchange

            total += q
            empty_bottles = q + r
            
        return total
        