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

package com.google.cloud.dataplex.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dataplex.v1.DataScanServiceClient;
import com.google.cloud.dataplex.v1.DataScanServiceSettings;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link DataScanServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@ConditionalOnClass(DataScanServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dataplex.v1.spring.auto.data-scan-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(DataScanServiceSpringProperties.class)
public class DataScanServiceSpringAutoConfiguration {
  private final DataScanServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(DataScanServiceSpringAutoConfiguration.class);

  protected DataScanServiceSpringAutoConfiguration(
      DataScanServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from DataScanService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultDataScanServiceTransportChannelProvider() {
    return DataScanServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a DataScanServiceClient bean configured to use the default credentials provider
   * (obtained with dataScanServiceCredentials()) and its default transport channel provider
   * (defaultDataScanServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in DataScanServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public DataScanServiceSettings dataScanServiceSettings(
      @Qualifier("defaultDataScanServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    DataScanServiceSettings.Builder clientSettingsBuilder =
        DataScanServiceSettings.newBuilder()
            .setCredentialsProvider(this.credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider)
            .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          DataScanServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder.setTransportChannelProvider(
          DataScanServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings createDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createDataScanSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createDataScanSettings().setRetrySettings(createDataScanRetrySettings);

      RetrySettings updateDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateDataScanSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateDataScanSettings().setRetrySettings(updateDataScanRetrySettings);

      RetrySettings deleteDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteDataScanSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteDataScanSettings().setRetrySettings(deleteDataScanRetrySettings);

      RetrySettings getDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDataScanSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getDataScanSettings().setRetrySettings(getDataScanRetrySettings);

      RetrySettings listDataScansRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDataScansSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listDataScansSettings().setRetrySettings(listDataScansRetrySettings);

      RetrySettings runDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.runDataScanSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.runDataScanSettings().setRetrySettings(runDataScanRetrySettings);

      RetrySettings getDataScanJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDataScanJobSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getDataScanJobSettings().setRetrySettings(getDataScanJobRetrySettings);

      RetrySettings listDataScanJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDataScanJobsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listDataScanJobsSettings()
          .setRetrySettings(listDataScanJobsRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry createDataScanRetry = clientProperties.getCreateDataScanRetry();
    if (createDataScanRetry != null) {
      RetrySettings createDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createDataScanSettings().getRetrySettings(),
              createDataScanRetry);
      clientSettingsBuilder.createDataScanSettings().setRetrySettings(createDataScanRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createDataScan from properties.");
      }
    }
    Retry updateDataScanRetry = clientProperties.getUpdateDataScanRetry();
    if (updateDataScanRetry != null) {
      RetrySettings updateDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateDataScanSettings().getRetrySettings(),
              updateDataScanRetry);
      clientSettingsBuilder.updateDataScanSettings().setRetrySettings(updateDataScanRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateDataScan from properties.");
      }
    }
    Retry deleteDataScanRetry = clientProperties.getDeleteDataScanRetry();
    if (deleteDataScanRetry != null) {
      RetrySettings deleteDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteDataScanSettings().getRetrySettings(),
              deleteDataScanRetry);
      clientSettingsBuilder.deleteDataScanSettings().setRetrySettings(deleteDataScanRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteDataScan from properties.");
      }
    }
    Retry getDataScanRetry = clientProperties.getGetDataScanRetry();
    if (getDataScanRetry != null) {
      RetrySettings getDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDataScanSettings().getRetrySettings(), getDataScanRetry);
      clientSettingsBuilder.getDataScanSettings().setRetrySettings(getDataScanRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getDataScan from properties.");
      }
    }
    Retry listDataScansRetry = clientProperties.getListDataScansRetry();
    if (listDataScansRetry != null) {
      RetrySettings listDataScansRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDataScansSettings().getRetrySettings(), listDataScansRetry);
      clientSettingsBuilder.listDataScansSettings().setRetrySettings(listDataScansRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listDataScans from properties.");
      }
    }
    Retry runDataScanRetry = clientProperties.getRunDataScanRetry();
    if (runDataScanRetry != null) {
      RetrySettings runDataScanRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.runDataScanSettings().getRetrySettings(), runDataScanRetry);
      clientSettingsBuilder.runDataScanSettings().setRetrySettings(runDataScanRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for runDataScan from properties.");
      }
    }
    Retry getDataScanJobRetry = clientProperties.getGetDataScanJobRetry();
    if (getDataScanJobRetry != null) {
      RetrySettings getDataScanJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDataScanJobSettings().getRetrySettings(),
              getDataScanJobRetry);
      clientSettingsBuilder.getDataScanJobSettings().setRetrySettings(getDataScanJobRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getDataScanJob from properties.");
      }
    }
    Retry listDataScanJobsRetry = clientProperties.getListDataScanJobsRetry();
    if (listDataScanJobsRetry != null) {
      RetrySettings listDataScanJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDataScanJobsSettings().getRetrySettings(),
              listDataScanJobsRetry);
      clientSettingsBuilder
          .listDataScanJobsSettings()
          .setRetrySettings(listDataScanJobsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listDataScanJobs from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public DataScanServiceClient dataScanServiceClient(
      DataScanServiceSettings dataScanServiceSettings) throws IOException {
    return DataScanServiceClient.create(dataScanServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-data-scan-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
