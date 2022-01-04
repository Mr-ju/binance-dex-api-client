package com.binance.dex.api.client.encoding.message;

import com.binance.dex.api.client.encoding.ToHexStringSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: fletcher.fan
 * @create: 2019-10-09
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
@Setter
@Getter
public class ClaimHtltMessage implements BinanceDexTransactionMessage {

    private String from;

    @JsonProperty("swap_id")
    private String swapId;

    @JsonProperty("random_number")
    @JsonSerialize(using = ToHexStringSerializer.class)
    private byte[] randomNumber;

}
