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

package com.google.cloud.metastore.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for DataprocMetastore client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.metastore.v1.spring.auto.dataproc-metastore")
public class DataprocMetastoreSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for listServices. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listServicesRetry;
  /**
   * Allow override of retry settings at method-level for getService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getServiceRetry;
  /**
   * Allow override of retry settings at method-level for createService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createServiceRetry;
  /**
   * Allow override of retry settings at method-level for updateService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateServiceRetry;
  /**
   * Allow override of retry settings at method-level for deleteService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteServiceRetry;
  /**
   * Allow override of retry settings at method-level for listMetadataImports. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listMetadataImportsRetry;
  /**
   * Allow override of retry settings at method-level for getMetadataImport. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getMetadataImportRetry;
  /**
   * Allow override of retry settings at method-level for createMetadataImport. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createMetadataImportRetry;
  /**
   * Allow override of retry settings at method-level for updateMetadataImport. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateMetadataImportRetry;
  /**
   * Allow override of retry settings at method-level for exportMetadata. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry exportMetadataRetry;
  /**
   * Allow override of retry settings at method-level for restoreService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry restoreServiceRetry;
  /**
   * Allow override of retry settings at method-level for listBackups. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listBackupsRetry;
  /**
   * Allow override of retry settings at method-level for getBackup. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getBackupRetry;
  /**
   * Allow override of retry settings at method-level for createBackup. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createBackupRetry;
  /**
   * Allow override of retry settings at method-level for deleteBackup. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteBackupRetry;

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

  public Retry getListServicesRetry() {
    return this.listServicesRetry;
  }

  public void setListServicesRetry(Retry listServicesRetry) {
    this.listServicesRetry = listServicesRetry;
  }

  public Retry getGetServiceRetry() {
    return this.getServiceRetry;
  }

  public void setGetServiceRetry(Retry getServiceRetry) {
    this.getServiceRetry = getServiceRetry;
  }

  public Retry getCreateServiceRetry() {
    return this.createServiceRetry;
  }

  public void setCreateServiceRetry(Retry createServiceRetry) {
    this.createServiceRetry = createServiceRetry;
  }

  public Retry getUpdateServiceRetry() {
    return this.updateServiceRetry;
  }

  public void setUpdateServiceRetry(Retry updateServiceRetry) {
    this.updateServiceRetry = updateServiceRetry;
  }

  public Retry getDeleteServiceRetry() {
    return this.deleteServiceRetry;
  }

  public void setDeleteServiceRetry(Retry deleteServiceRetry) {
    this.deleteServiceRetry = deleteServiceRetry;
  }

  public Retry getListMetadataImportsRetry() {
    return this.listMetadataImportsRetry;
  }

  public void setListMetadataImportsRetry(Retry listMetadataImportsRetry) {
    this.listMetadataImportsRetry = listMetadataImportsRetry;
  }

  public Retry getGetMetadataImportRetry() {
    return this.getMetadataImportRetry;
  }

  public void setGetMetadataImportRetry(Retry getMetadataImportRetry) {
    this.getMetadataImportRetry = getMetadataImportRetry;
  }

  public Retry getCreateMetadataImportRetry() {
    return this.createMetadataImportRetry;
  }

  public void setCreateMetadataImportRetry(Retry createMetadataImportRetry) {
    this.createMetadataImportRetry = createMetadataImportRetry;
  }

  public Retry getUpdateMetadataImportRetry() {
    return this.updateMetadataImportRetry;
  }

  public void setUpdateMetadataImportRetry(Retry updateMetadataImportRetry) {
    this.updateMetadataImportRetry = updateMetadataImportRetry;
  }

  public Retry getExportMetadataRetry() {
    return this.exportMetadataRetry;
  }

  public void setExportMetadataRetry(Retry exportMetadataRetry) {
    this.exportMetadataRetry = exportMetadataRetry;
  }

  public Retry getRestoreServiceRetry() {
    return this.restoreServiceRetry;
  }

  public void setRestoreServiceRetry(Retry restoreServiceRetry) {
    this.restoreServiceRetry = restoreServiceRetry;
  }

  public Retry getListBackupsRetry() {
    return this.listBackupsRetry;
  }

  public void setListBackupsRetry(Retry listBackupsRetry) {
    this.listBackupsRetry = listBackupsRetry;
  }

  public Retry getGetBackupRetry() {
    return this.getBackupRetry;
  }

  public void setGetBackupRetry(Retry getBackupRetry) {
    this.getBackupRetry = getBackupRetry;
  }

  public Retry getCreateBackupRetry() {
    return this.createBackupRetry;
  }

  public void setCreateBackupRetry(Retry createBackupRetry) {
    this.createBackupRetry = createBackupRetry;
  }

  public Retry getDeleteBackupRetry() {
    return this.deleteBackupRetry;
  }

  public void setDeleteBackupRetry(Retry deleteBackupRetry) {
    this.deleteBackupRetry = deleteBackupRetry;
  }
}
