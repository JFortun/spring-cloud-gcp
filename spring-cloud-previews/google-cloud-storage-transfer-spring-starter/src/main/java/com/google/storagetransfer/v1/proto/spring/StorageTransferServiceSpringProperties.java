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

package com.google.storagetransfer.v1.proto.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for StorageTransferService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.storagetransfer.v1.proto.spring.auto.storage-transfer-service")
public class StorageTransferServiceSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for getGoogleServiceAccount. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getGoogleServiceAccountRetry;
  /**
   * Allow override of retry settings at method-level for createTransferJob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createTransferJobRetry;
  /**
   * Allow override of retry settings at method-level for updateTransferJob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateTransferJobRetry;
  /**
   * Allow override of retry settings at method-level for getTransferJob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getTransferJobRetry;
  /**
   * Allow override of retry settings at method-level for listTransferJobs. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listTransferJobsRetry;
  /**
   * Allow override of retry settings at method-level for pauseTransferOperation. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry pauseTransferOperationRetry;
  /**
   * Allow override of retry settings at method-level for resumeTransferOperation. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry resumeTransferOperationRetry;
  /**
   * Allow override of retry settings at method-level for runTransferJob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry runTransferJobRetry;
  /**
   * Allow override of retry settings at method-level for deleteTransferJob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteTransferJobRetry;
  /**
   * Allow override of retry settings at method-level for createAgentPool. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createAgentPoolRetry;
  /**
   * Allow override of retry settings at method-level for updateAgentPool. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateAgentPoolRetry;
  /**
   * Allow override of retry settings at method-level for getAgentPool. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getAgentPoolRetry;
  /**
   * Allow override of retry settings at method-level for listAgentPools. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listAgentPoolsRetry;
  /**
   * Allow override of retry settings at method-level for deleteAgentPool. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteAgentPoolRetry;

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

  public Retry getGetGoogleServiceAccountRetry() {
    return this.getGoogleServiceAccountRetry;
  }

  public void setGetGoogleServiceAccountRetry(Retry getGoogleServiceAccountRetry) {
    this.getGoogleServiceAccountRetry = getGoogleServiceAccountRetry;
  }

  public Retry getCreateTransferJobRetry() {
    return this.createTransferJobRetry;
  }

  public void setCreateTransferJobRetry(Retry createTransferJobRetry) {
    this.createTransferJobRetry = createTransferJobRetry;
  }

  public Retry getUpdateTransferJobRetry() {
    return this.updateTransferJobRetry;
  }

  public void setUpdateTransferJobRetry(Retry updateTransferJobRetry) {
    this.updateTransferJobRetry = updateTransferJobRetry;
  }

  public Retry getGetTransferJobRetry() {
    return this.getTransferJobRetry;
  }

  public void setGetTransferJobRetry(Retry getTransferJobRetry) {
    this.getTransferJobRetry = getTransferJobRetry;
  }

  public Retry getListTransferJobsRetry() {
    return this.listTransferJobsRetry;
  }

  public void setListTransferJobsRetry(Retry listTransferJobsRetry) {
    this.listTransferJobsRetry = listTransferJobsRetry;
  }

  public Retry getPauseTransferOperationRetry() {
    return this.pauseTransferOperationRetry;
  }

  public void setPauseTransferOperationRetry(Retry pauseTransferOperationRetry) {
    this.pauseTransferOperationRetry = pauseTransferOperationRetry;
  }

  public Retry getResumeTransferOperationRetry() {
    return this.resumeTransferOperationRetry;
  }

  public void setResumeTransferOperationRetry(Retry resumeTransferOperationRetry) {
    this.resumeTransferOperationRetry = resumeTransferOperationRetry;
  }

  public Retry getRunTransferJobRetry() {
    return this.runTransferJobRetry;
  }

  public void setRunTransferJobRetry(Retry runTransferJobRetry) {
    this.runTransferJobRetry = runTransferJobRetry;
  }

  public Retry getDeleteTransferJobRetry() {
    return this.deleteTransferJobRetry;
  }

  public void setDeleteTransferJobRetry(Retry deleteTransferJobRetry) {
    this.deleteTransferJobRetry = deleteTransferJobRetry;
  }

  public Retry getCreateAgentPoolRetry() {
    return this.createAgentPoolRetry;
  }

  public void setCreateAgentPoolRetry(Retry createAgentPoolRetry) {
    this.createAgentPoolRetry = createAgentPoolRetry;
  }

  public Retry getUpdateAgentPoolRetry() {
    return this.updateAgentPoolRetry;
  }

  public void setUpdateAgentPoolRetry(Retry updateAgentPoolRetry) {
    this.updateAgentPoolRetry = updateAgentPoolRetry;
  }

  public Retry getGetAgentPoolRetry() {
    return this.getAgentPoolRetry;
  }

  public void setGetAgentPoolRetry(Retry getAgentPoolRetry) {
    this.getAgentPoolRetry = getAgentPoolRetry;
  }

  public Retry getListAgentPoolsRetry() {
    return this.listAgentPoolsRetry;
  }

  public void setListAgentPoolsRetry(Retry listAgentPoolsRetry) {
    this.listAgentPoolsRetry = listAgentPoolsRetry;
  }

  public Retry getDeleteAgentPoolRetry() {
    return this.deleteAgentPoolRetry;
  }

  public void setDeleteAgentPoolRetry(Retry deleteAgentPoolRetry) {
    this.deleteAgentPoolRetry = deleteAgentPoolRetry;
  }
}
