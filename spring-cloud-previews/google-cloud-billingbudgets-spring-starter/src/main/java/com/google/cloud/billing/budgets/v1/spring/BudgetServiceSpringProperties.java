/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.billing.budgets.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for BudgetService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.billing.budgets.v1.spring.auto.budget-service")
public class BudgetServiceSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials(
          "https://www.googleapis.com/auth/cloud-billing",
          "https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for createBudget. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createBudgetRetry;
  /**
   * Allow override of retry settings at method-level for updateBudget. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateBudgetRetry;
  /**
   * Allow override of retry settings at method-level for getBudget. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getBudgetRetry;
  /**
   * Allow override of retry settings at method-level for listBudgets. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listBudgetsRetry;
  /**
   * Allow override of retry settings at method-level for deleteBudget. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteBudgetRetry;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getCreateBudgetRetry() {
    return this.createBudgetRetry;
  }

  public void setCreateBudgetRetry(Retry createBudgetRetry) {
    this.createBudgetRetry = createBudgetRetry;
  }

  public Retry getUpdateBudgetRetry() {
    return this.updateBudgetRetry;
  }

  public void setUpdateBudgetRetry(Retry updateBudgetRetry) {
    this.updateBudgetRetry = updateBudgetRetry;
  }

  public Retry getGetBudgetRetry() {
    return this.getBudgetRetry;
  }

  public void setGetBudgetRetry(Retry getBudgetRetry) {
    this.getBudgetRetry = getBudgetRetry;
  }

  public Retry getListBudgetsRetry() {
    return this.listBudgetsRetry;
  }

  public void setListBudgetsRetry(Retry listBudgetsRetry) {
    this.listBudgetsRetry = listBudgetsRetry;
  }

  public Retry getDeleteBudgetRetry() {
    return this.deleteBudgetRetry;
  }

  public void setDeleteBudgetRetry(Retry deleteBudgetRetry) {
    this.deleteBudgetRetry = deleteBudgetRetry;
  }
}
