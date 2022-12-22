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

package com.google.cloud.aiplatform.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for IndexEndpointService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.aiplatform.v1.spring.auto.index-endpoint-service")
public class IndexEndpointServiceSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for createIndexEndpoint. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createIndexEndpointRetry;
  /**
   * Allow override of retry settings at method-level for getIndexEndpoint. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIndexEndpointRetry;
  /**
   * Allow override of retry settings at method-level for listIndexEndpoints. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listIndexEndpointsRetry;
  /**
   * Allow override of retry settings at method-level for updateIndexEndpoint. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateIndexEndpointRetry;
  /**
   * Allow override of retry settings at method-level for deleteIndexEndpoint. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteIndexEndpointRetry;
  /**
   * Allow override of retry settings at method-level for deployIndex. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deployIndexRetry;
  /**
   * Allow override of retry settings at method-level for undeployIndex. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry undeployIndexRetry;
  /**
   * Allow override of retry settings at method-level for mutateDeployedIndex. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry mutateDeployedIndexRetry;
  /**
   * Allow override of retry settings at method-level for listLocations. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listLocationsRetry;
  /**
   * Allow override of retry settings at method-level for getLocation. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getLocationRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;

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

  public Retry getCreateIndexEndpointRetry() {
    return this.createIndexEndpointRetry;
  }

  public void setCreateIndexEndpointRetry(Retry createIndexEndpointRetry) {
    this.createIndexEndpointRetry = createIndexEndpointRetry;
  }

  public Retry getGetIndexEndpointRetry() {
    return this.getIndexEndpointRetry;
  }

  public void setGetIndexEndpointRetry(Retry getIndexEndpointRetry) {
    this.getIndexEndpointRetry = getIndexEndpointRetry;
  }

  public Retry getListIndexEndpointsRetry() {
    return this.listIndexEndpointsRetry;
  }

  public void setListIndexEndpointsRetry(Retry listIndexEndpointsRetry) {
    this.listIndexEndpointsRetry = listIndexEndpointsRetry;
  }

  public Retry getUpdateIndexEndpointRetry() {
    return this.updateIndexEndpointRetry;
  }

  public void setUpdateIndexEndpointRetry(Retry updateIndexEndpointRetry) {
    this.updateIndexEndpointRetry = updateIndexEndpointRetry;
  }

  public Retry getDeleteIndexEndpointRetry() {
    return this.deleteIndexEndpointRetry;
  }

  public void setDeleteIndexEndpointRetry(Retry deleteIndexEndpointRetry) {
    this.deleteIndexEndpointRetry = deleteIndexEndpointRetry;
  }

  public Retry getDeployIndexRetry() {
    return this.deployIndexRetry;
  }

  public void setDeployIndexRetry(Retry deployIndexRetry) {
    this.deployIndexRetry = deployIndexRetry;
  }

  public Retry getUndeployIndexRetry() {
    return this.undeployIndexRetry;
  }

  public void setUndeployIndexRetry(Retry undeployIndexRetry) {
    this.undeployIndexRetry = undeployIndexRetry;
  }

  public Retry getMutateDeployedIndexRetry() {
    return this.mutateDeployedIndexRetry;
  }

  public void setMutateDeployedIndexRetry(Retry mutateDeployedIndexRetry) {
    this.mutateDeployedIndexRetry = mutateDeployedIndexRetry;
  }

  public Retry getListLocationsRetry() {
    return this.listLocationsRetry;
  }

  public void setListLocationsRetry(Retry listLocationsRetry) {
    this.listLocationsRetry = listLocationsRetry;
  }

  public Retry getGetLocationRetry() {
    return this.getLocationRetry;
  }

  public void setGetLocationRetry(Retry getLocationRetry) {
    this.getLocationRetry = getLocationRetry;
  }

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }
}
