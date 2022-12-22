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
/** Provides default property values for MetadataService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.aiplatform.v1.spring.auto.metadata-service")
public class MetadataServiceSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for createMetadataStore. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createMetadataStoreRetry;
  /**
   * Allow override of retry settings at method-level for getMetadataStore. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getMetadataStoreRetry;
  /**
   * Allow override of retry settings at method-level for listMetadataStores. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listMetadataStoresRetry;
  /**
   * Allow override of retry settings at method-level for deleteMetadataStore. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteMetadataStoreRetry;
  /**
   * Allow override of retry settings at method-level for createArtifact. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createArtifactRetry;
  /**
   * Allow override of retry settings at method-level for getArtifact. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getArtifactRetry;
  /**
   * Allow override of retry settings at method-level for listArtifacts. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listArtifactsRetry;
  /**
   * Allow override of retry settings at method-level for updateArtifact. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateArtifactRetry;
  /**
   * Allow override of retry settings at method-level for deleteArtifact. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteArtifactRetry;
  /**
   * Allow override of retry settings at method-level for purgeArtifacts. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry purgeArtifactsRetry;
  /**
   * Allow override of retry settings at method-level for createContext. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createContextRetry;
  /**
   * Allow override of retry settings at method-level for getContext. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getContextRetry;
  /**
   * Allow override of retry settings at method-level for listContexts. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listContextsRetry;
  /**
   * Allow override of retry settings at method-level for updateContext. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateContextRetry;
  /**
   * Allow override of retry settings at method-level for deleteContext. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteContextRetry;
  /**
   * Allow override of retry settings at method-level for purgeContexts. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry purgeContextsRetry;
  /**
   * Allow override of retry settings at method-level for addContextArtifactsAndExecutions. If
   * defined, this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry addContextArtifactsAndExecutionsRetry;
  /**
   * Allow override of retry settings at method-level for addContextChildren. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry addContextChildrenRetry;
  /**
   * Allow override of retry settings at method-level for removeContextChildren. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry removeContextChildrenRetry;
  /**
   * Allow override of retry settings at method-level for queryContextLineageSubgraph. If defined,
   * this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry queryContextLineageSubgraphRetry;
  /**
   * Allow override of retry settings at method-level for createExecution. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createExecutionRetry;
  /**
   * Allow override of retry settings at method-level for getExecution. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getExecutionRetry;
  /**
   * Allow override of retry settings at method-level for listExecutions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listExecutionsRetry;
  /**
   * Allow override of retry settings at method-level for updateExecution. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateExecutionRetry;
  /**
   * Allow override of retry settings at method-level for deleteExecution. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteExecutionRetry;
  /**
   * Allow override of retry settings at method-level for purgeExecutions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry purgeExecutionsRetry;
  /**
   * Allow override of retry settings at method-level for addExecutionEvents. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry addExecutionEventsRetry;
  /**
   * Allow override of retry settings at method-level for queryExecutionInputsAndOutputs. If
   * defined, this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry queryExecutionInputsAndOutputsRetry;
  /**
   * Allow override of retry settings at method-level for createMetadataSchema. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createMetadataSchemaRetry;
  /**
   * Allow override of retry settings at method-level for getMetadataSchema. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getMetadataSchemaRetry;
  /**
   * Allow override of retry settings at method-level for listMetadataSchemas. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listMetadataSchemasRetry;
  /**
   * Allow override of retry settings at method-level for queryArtifactLineageSubgraph. If defined,
   * this takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry queryArtifactLineageSubgraphRetry;
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

  public Retry getCreateMetadataStoreRetry() {
    return this.createMetadataStoreRetry;
  }

  public void setCreateMetadataStoreRetry(Retry createMetadataStoreRetry) {
    this.createMetadataStoreRetry = createMetadataStoreRetry;
  }

  public Retry getGetMetadataStoreRetry() {
    return this.getMetadataStoreRetry;
  }

  public void setGetMetadataStoreRetry(Retry getMetadataStoreRetry) {
    this.getMetadataStoreRetry = getMetadataStoreRetry;
  }

  public Retry getListMetadataStoresRetry() {
    return this.listMetadataStoresRetry;
  }

  public void setListMetadataStoresRetry(Retry listMetadataStoresRetry) {
    this.listMetadataStoresRetry = listMetadataStoresRetry;
  }

  public Retry getDeleteMetadataStoreRetry() {
    return this.deleteMetadataStoreRetry;
  }

  public void setDeleteMetadataStoreRetry(Retry deleteMetadataStoreRetry) {
    this.deleteMetadataStoreRetry = deleteMetadataStoreRetry;
  }

  public Retry getCreateArtifactRetry() {
    return this.createArtifactRetry;
  }

  public void setCreateArtifactRetry(Retry createArtifactRetry) {
    this.createArtifactRetry = createArtifactRetry;
  }

  public Retry getGetArtifactRetry() {
    return this.getArtifactRetry;
  }

  public void setGetArtifactRetry(Retry getArtifactRetry) {
    this.getArtifactRetry = getArtifactRetry;
  }

  public Retry getListArtifactsRetry() {
    return this.listArtifactsRetry;
  }

  public void setListArtifactsRetry(Retry listArtifactsRetry) {
    this.listArtifactsRetry = listArtifactsRetry;
  }

  public Retry getUpdateArtifactRetry() {
    return this.updateArtifactRetry;
  }

  public void setUpdateArtifactRetry(Retry updateArtifactRetry) {
    this.updateArtifactRetry = updateArtifactRetry;
  }

  public Retry getDeleteArtifactRetry() {
    return this.deleteArtifactRetry;
  }

  public void setDeleteArtifactRetry(Retry deleteArtifactRetry) {
    this.deleteArtifactRetry = deleteArtifactRetry;
  }

  public Retry getPurgeArtifactsRetry() {
    return this.purgeArtifactsRetry;
  }

  public void setPurgeArtifactsRetry(Retry purgeArtifactsRetry) {
    this.purgeArtifactsRetry = purgeArtifactsRetry;
  }

  public Retry getCreateContextRetry() {
    return this.createContextRetry;
  }

  public void setCreateContextRetry(Retry createContextRetry) {
    this.createContextRetry = createContextRetry;
  }

  public Retry getGetContextRetry() {
    return this.getContextRetry;
  }

  public void setGetContextRetry(Retry getContextRetry) {
    this.getContextRetry = getContextRetry;
  }

  public Retry getListContextsRetry() {
    return this.listContextsRetry;
  }

  public void setListContextsRetry(Retry listContextsRetry) {
    this.listContextsRetry = listContextsRetry;
  }

  public Retry getUpdateContextRetry() {
    return this.updateContextRetry;
  }

  public void setUpdateContextRetry(Retry updateContextRetry) {
    this.updateContextRetry = updateContextRetry;
  }

  public Retry getDeleteContextRetry() {
    return this.deleteContextRetry;
  }

  public void setDeleteContextRetry(Retry deleteContextRetry) {
    this.deleteContextRetry = deleteContextRetry;
  }

  public Retry getPurgeContextsRetry() {
    return this.purgeContextsRetry;
  }

  public void setPurgeContextsRetry(Retry purgeContextsRetry) {
    this.purgeContextsRetry = purgeContextsRetry;
  }

  public Retry getAddContextArtifactsAndExecutionsRetry() {
    return this.addContextArtifactsAndExecutionsRetry;
  }

  public void setAddContextArtifactsAndExecutionsRetry(
      Retry addContextArtifactsAndExecutionsRetry) {
    this.addContextArtifactsAndExecutionsRetry = addContextArtifactsAndExecutionsRetry;
  }

  public Retry getAddContextChildrenRetry() {
    return this.addContextChildrenRetry;
  }

  public void setAddContextChildrenRetry(Retry addContextChildrenRetry) {
    this.addContextChildrenRetry = addContextChildrenRetry;
  }

  public Retry getRemoveContextChildrenRetry() {
    return this.removeContextChildrenRetry;
  }

  public void setRemoveContextChildrenRetry(Retry removeContextChildrenRetry) {
    this.removeContextChildrenRetry = removeContextChildrenRetry;
  }

  public Retry getQueryContextLineageSubgraphRetry() {
    return this.queryContextLineageSubgraphRetry;
  }

  public void setQueryContextLineageSubgraphRetry(Retry queryContextLineageSubgraphRetry) {
    this.queryContextLineageSubgraphRetry = queryContextLineageSubgraphRetry;
  }

  public Retry getCreateExecutionRetry() {
    return this.createExecutionRetry;
  }

  public void setCreateExecutionRetry(Retry createExecutionRetry) {
    this.createExecutionRetry = createExecutionRetry;
  }

  public Retry getGetExecutionRetry() {
    return this.getExecutionRetry;
  }

  public void setGetExecutionRetry(Retry getExecutionRetry) {
    this.getExecutionRetry = getExecutionRetry;
  }

  public Retry getListExecutionsRetry() {
    return this.listExecutionsRetry;
  }

  public void setListExecutionsRetry(Retry listExecutionsRetry) {
    this.listExecutionsRetry = listExecutionsRetry;
  }

  public Retry getUpdateExecutionRetry() {
    return this.updateExecutionRetry;
  }

  public void setUpdateExecutionRetry(Retry updateExecutionRetry) {
    this.updateExecutionRetry = updateExecutionRetry;
  }

  public Retry getDeleteExecutionRetry() {
    return this.deleteExecutionRetry;
  }

  public void setDeleteExecutionRetry(Retry deleteExecutionRetry) {
    this.deleteExecutionRetry = deleteExecutionRetry;
  }

  public Retry getPurgeExecutionsRetry() {
    return this.purgeExecutionsRetry;
  }

  public void setPurgeExecutionsRetry(Retry purgeExecutionsRetry) {
    this.purgeExecutionsRetry = purgeExecutionsRetry;
  }

  public Retry getAddExecutionEventsRetry() {
    return this.addExecutionEventsRetry;
  }

  public void setAddExecutionEventsRetry(Retry addExecutionEventsRetry) {
    this.addExecutionEventsRetry = addExecutionEventsRetry;
  }

  public Retry getQueryExecutionInputsAndOutputsRetry() {
    return this.queryExecutionInputsAndOutputsRetry;
  }

  public void setQueryExecutionInputsAndOutputsRetry(Retry queryExecutionInputsAndOutputsRetry) {
    this.queryExecutionInputsAndOutputsRetry = queryExecutionInputsAndOutputsRetry;
  }

  public Retry getCreateMetadataSchemaRetry() {
    return this.createMetadataSchemaRetry;
  }

  public void setCreateMetadataSchemaRetry(Retry createMetadataSchemaRetry) {
    this.createMetadataSchemaRetry = createMetadataSchemaRetry;
  }

  public Retry getGetMetadataSchemaRetry() {
    return this.getMetadataSchemaRetry;
  }

  public void setGetMetadataSchemaRetry(Retry getMetadataSchemaRetry) {
    this.getMetadataSchemaRetry = getMetadataSchemaRetry;
  }

  public Retry getListMetadataSchemasRetry() {
    return this.listMetadataSchemasRetry;
  }

  public void setListMetadataSchemasRetry(Retry listMetadataSchemasRetry) {
    this.listMetadataSchemasRetry = listMetadataSchemasRetry;
  }

  public Retry getQueryArtifactLineageSubgraphRetry() {
    return this.queryArtifactLineageSubgraphRetry;
  }

  public void setQueryArtifactLineageSubgraphRetry(Retry queryArtifactLineageSubgraphRetry) {
    this.queryArtifactLineageSubgraphRetry = queryArtifactLineageSubgraphRetry;
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
