package com.binance.dex.api.client.encoding.message;

import com.binance.dex.api.client.BinanceDexApiClientFactory;
import com.binance.dex.api.client.BinanceDexApiRestClient;
import com.binance.dex.api.client.BinanceDexEnvironment;
import com.binance.dex.api.client.domain.*;
import com.binance.dex.api.client.domain.Token;
import com.binance.dex.api.client.domain.request.TradesRequest;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore("Manual run only")
public class TestRestClient {
    private BinanceDexApiRestClient client =
            BinanceDexApiClientFactory.newInstance().newRestClient("https://dex-api.fdgahl.cn");

    private String address = "tbnb16hywxpvvkaz6cecjz89mf2w0da3vfeg6z6yky2";

    private String symbol = "ADA.B-F2F_BNB";

    private String miniSymbol = "MSDK-400M_BNB";

    @Test
    public void testGetMarkets() {
        List<Market> mkts = client.getMarkets(1000);
        for (Market m : mkts) {
            System.out.println(m);
        }
    }

    @Test
    public void testGetTime() {
        Time time = client.getTime();
        System.out.println(time);

    }

    @Test
    public void testGetAccount() {
        Account account = client.getAccount(address);
        System.out.println(account);
    }

    @Test
    public void testGetAccountSequence() {
        AccountSequence accountSequence = client.getAccountSequence(address);
        System.out.println(accountSequence);
    }

    @Test
    public void testGetTransactionMetaData() {
        TransactionMetadata tx =
                client.getTransactionMetadata("72DA25FE19DF6E9D449A6D68320EE99895444ABAC62A054D7BE7E08352D94250");
        System.out.println(tx);
    }

    @Test
    public void testGetToken() {
        List<Token> tokens = client.getTokens(100);
        System.out.println(tokens);
    }

    @Test
    public void testGetOrderBook() {
        OrderBook ob = client.getOrderBook(symbol, 5);
        System.out.println(ob);
    }

    @Test
    public void testGetCandlestickBars() {
        List<Candlestick> klines = client.getCandleStickBars(symbol, CandlestickInterval.HOURLY);
        System.out.println(klines);

        System.out.println(client.getCandleStickBars(symbol, CandlestickInterval.ONE_MINUTE,
                10, System.currentTimeMillis() - 24L * 60 * 60 * 1000L, null));
    }

    @Test
    public void testGetNodeInfo() {
        Infos infos = client.getNodeInfo();
        System.out.println(infos);
    }

    @Test
    public void testGetOpenOrders() {
        System.out.println(client.getOpenOrders(address));
    }

    @Test
    public void testGetClosedOrders() {
        System.out.println(client.getClosedOrders(address));
    }

    @Test
    public void testGet24HrPriceStatistics() {
        System.out.println(client.get24HrPriceStatistics());
    }

    @Test
    public void testGetTrades() {
        System.out.println(client.getTrades());
        TradesRequest request = new TradesRequest();
        request.setAddress(address);
        request.setLimit(10);
        System.out.println(client.getTrades(request));
    }

    @Test
    public void testGetTransactions() {
        System.out.println(client.getTransactions(address));
    }

    @Test
    public void testGetValidators() {
        System.out.println(client.getValidators());
    }

    @Test
    public void testGetPeers() {
        System.out.println(client.getPeers());
    }

    @Test
    public void testGetFees() {
        List<Fees> fees = client.getFees();
        System.out.println(fees);
    }

    @Test
    public void testGetMiniToken() {
        List<MiniToken> tokens = client.getMiniTokens(100);
        System.out.println(tokens);
    }

    @Test
    public void testGetMiniMarkets() {
        List<Market> mkts = client.getMiniMarkets(1000);
        for (Market m : mkts) {
            System.out.println(m);
        }
    }

    @Test
    public void testGetMiniCandlestickBars() {
        List<Candlestick> klines = client.getMiniCandleStickBars(miniSymbol, CandlestickInterval.HOURLY);
        System.out.println(klines);

        System.out.println(client.getMiniCandleStickBars(miniSymbol, CandlestickInterval.ONE_MINUTE,
                10, System.currentTimeMillis() - 24L * 60 * 60 * 1000L, null));
    }

    @Test
    public void testGetMiniOpenOrders() {
        System.out.println(client.getMiniOpenOrders(address));
    }

    @Test
    public void testGetMiniClosedOrders() {
        System.out.println(client.getMiniClosedOrders(address));
    }

    @Test
    public void testGetMini24HrPriceStatistics() {
        System.out.println(client.getMini24HrPriceStatistics());
        System.out.println(client.getMini24HrPriceStatistics(miniSymbol));
    }

    @Test
    public void testGetMiniTrades() {
        System.out.println(client.getMiniTrades());
        TradesRequest request = new TradesRequest();
        request.setAddress(address);
        request.setLimit(10);
        System.out.println(client.getMiniTrades(request));
    }
}
