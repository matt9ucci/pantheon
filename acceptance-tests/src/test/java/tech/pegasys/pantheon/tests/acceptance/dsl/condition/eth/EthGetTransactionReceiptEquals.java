/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.pantheon.tests.acceptance.dsl.condition.eth;

import static org.assertj.core.api.Assertions.assertThat;

import tech.pegasys.pantheon.tests.acceptance.dsl.condition.Condition;
import tech.pegasys.pantheon.tests.acceptance.dsl.node.Node;
import tech.pegasys.pantheon.tests.acceptance.dsl.transaction.eth.EthGetTransactionReceiptTransaction;

import java.util.Optional;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class EthGetTransactionReceiptEquals implements Condition {

  private final EthGetTransactionReceiptTransaction transaction;
  private final TransactionReceipt expectedReceipt;

  public EthGetTransactionReceiptEquals(
      final EthGetTransactionReceiptTransaction transaction,
      final TransactionReceipt expectedReceipt) {
    this.transaction = transaction;
    this.expectedReceipt = expectedReceipt;
  }

  @Override
  public void verify(final Node node) {
    final Optional<TransactionReceipt> response = node.execute(transaction);

    assertThat(response.isPresent()).isTrue();
    assertThat(response.get()).isEqualTo(expectedReceipt);
  }
}
