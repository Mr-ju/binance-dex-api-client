package com.binance.dex.api.client.utils.converter.impl;

import com.binance.dex.api.client.domain.Transaction;
import com.binance.dex.api.client.domain.TransactionV2;
import com.binance.dex.api.client.domain.broadcast.Listing;
import com.binance.dex.api.client.domain.broadcast.TxType;
import com.binance.dex.api.client.utils.converter.JsonUtil;
import com.binance.dex.api.client.utils.converter.NumberUtil;
import com.binance.dex.api.client.utils.converter.TransactionConverter;

import java.util.Map;

public class FListingConverter extends TransactionConverter<Listing> {

    @Override
    public TxType getType() {
        return TxType.LISTING;
    }

    @Override
    public void doConvert(TransactionV2 transactionV2, Transaction transaction) {
        Map<String, Object> map = JsonUtil.fromJson(transactionV2.getData(), Map.class);
        Long initPrice = ((Number) map.get("initPrice")).longValue();
        transaction.setValue(NumberUtil.longToBigDecimalString(initPrice));

        String asset = (String) map.get("baseAsset");
        transaction.setTxAsset(asset);

        transaction.setData(null);
    }
}
