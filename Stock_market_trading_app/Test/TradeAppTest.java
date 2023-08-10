import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TradeAppTest {
    private TradeApp tradeApp;

    @Before
    public void setUp() {
        tradeApp = new TradeApp("testUser");
    }

    @Test
    public void testAmountExists() throws JSONException, IOException {
        tradeApp.stockAccounts.buyStock("AAPL", 10);
        assertTrue(tradeApp.amountExists("AAPL", 5));
        assertFalse(tradeApp.amountExists("AAPL", 15));
        assertFalse(tradeApp.amountExists("GOOGL", 1));
    }

    @Test
    public void testPossibleAmount() throws JSONException {
        double price = new Stock("AAPL").getcp();
        int amount = 5;
        double expectedTotal = price * amount;
        double actualTotal = tradeApp.possibleAmount("AAPL", amount);
        assertEquals(expectedTotal, actualTotal, 0.01);
    }
}