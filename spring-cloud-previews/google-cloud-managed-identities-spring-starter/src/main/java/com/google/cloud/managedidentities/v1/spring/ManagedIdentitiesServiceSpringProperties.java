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

package com.google.cloud.managedidentities.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for ManagedIdentitiesService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties(
    "com.google.cloud.managedidentities.v1.spring.auto.managed-identities-service")
public class ManagedIdentitiesServiceSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for createMicrosoftAdDomain. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createMicrosoftAdDomainRetry;
  /**
   * Allow override of retry settings at method-level for resetAdminPassword. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry resetAdminPasswordRetry;
  /**
   * Allow override of retry settings at method-level for listDomains. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listDomainsRetry;
  /**
   * Allow override of retry settings at method-level for getDomain. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getDomainRetry;
  /**
   * Allow override of retry settings at method-level for updateDomain. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateDomainRetry;
  /**
   * Allow override of retry settings at method-level for deleteDomain. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteDomainRetry;
  /**
   * Allow override of retry settings at method-level for attachTrust. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry attachTrustRetry;
  /**
   * Allow override of retry settings at method-level for reconfigureTrust. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry reconfigureTrustRetry;
  /**
   * Allow override of retry settings at method-level for detachTrust. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry detachTrustRetry;
  /**
   * Allow override of retry settings at method-level for validateTrust. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry validateTrustRetry;

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

  public Retry getCreateMicrosoftAdDomainRetry() {
    return this.createMicrosoftAdDomainRetry;
  }

  public void setCreateMicrosoftAdDomainRetry(Retry createMicrosoftAdDomainRetry) {
    this.createMicrosoftAdDomainRetry = createMicrosoftAdDomainRetry;
  }

  public Retry getResetAdminPasswordRetry() {
    return this.resetAdminPasswordRetry;
  }

  public void setResetAdminPasswordRetry(Retry resetAdminPasswordRetry) {
    this.resetAdminPasswordRetry = resetAdminPasswordRetry;
  }

  public Retry getListDomainsRetry() {
    return this.listDomainsRetry;
  }

  public void setListDomainsRetry(Retry listDomainsRetry) {
    this.listDomainsRetry = listDomainsRetry;
  }

  public Retry getGetDomainRetry() {
    return this.getDomainRetry;
  }

  public void setGetDomainRetry(Retry getDomainRetry) {
    this.getDomainRetry = getDomainRetry;
  }

  public Retry getUpdateDomainRetry() {
    return this.updateDomainRetry;
  }

  public void setUpdateDomainRetry(Retry updateDomainRetry) {
    this.updateDomainRetry = updateDomainRetry;
  }

  public Retry getDeleteDomainRetry() {
    return this.deleteDomainRetry;
  }

  public void setDeleteDomainRetry(Retry deleteDomainRetry) {
    this.deleteDomainRetry = deleteDomainRetry;
  }

  public Retry getAttachTrustRetry() {
    return this.attachTrustRetry;
  }

  public void setAttachTrustRetry(Retry attachTrustRetry) {
    this.attachTrustRetry = attachTrustRetry;
  }

  public Retry getReconfigureTrustRetry() {
    return this.reconfigureTrustRetry;
  }

  public void setReconfigureTrustRetry(Retry reconfigureTrustRetry) {
    this.reconfigureTrustRetry = reconfigureTrustRetry;
  }

  public Retry getDetachTrustRetry() {
    return this.detachTrustRetry;
  }

  public void setDetachTrustRetry(Retry detachTrustRetry) {
    this.detachTrustRetry = detachTrustRetry;
  }

  public Retry getValidateTrustRetry() {
    return this.validateTrustRetry;
  }

  public void setValidateTrustRetry(Retry validateTrustRetry) {
    this.validateTrustRetry = validateTrustRetry;
  }
}
