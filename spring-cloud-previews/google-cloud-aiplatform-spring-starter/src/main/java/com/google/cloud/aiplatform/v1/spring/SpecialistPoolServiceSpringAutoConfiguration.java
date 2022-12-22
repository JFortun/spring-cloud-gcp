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
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.aiplatform.v1.SpecialistPoolServiceClient;
import com.google.cloud.aiplatform.v1.SpecialistPoolServiceSettings;
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
 * Auto-configuration for {@link SpecialistPoolServiceClient}.
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
@ConditionalOnClass(SpecialistPoolServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.aiplatform.v1.spring.auto.specialist-pool-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(SpecialistPoolServiceSpringProperties.class)
public class SpecialistPoolServiceSpringAutoConfiguration {
  private final SpecialistPoolServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(SpecialistPoolServiceSpringAutoConfiguration.class);

  protected SpecialistPoolServiceSpringAutoConfiguration(
      SpecialistPoolServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from SpecialistPoolService-specific configuration");
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
  public TransportChannelProvider defaultSpecialistPoolServiceTransportChannelProvider() {
    return SpecialistPoolServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a SpecialistPoolServiceClient bean configured to use the default credentials provider
   * (obtained with specialistPoolServiceCredentials()) and its default transport channel provider
   * (defaultSpecialistPoolServiceTransportChannelProvider()). It also configures the quota project
   * ID if provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in SpecialistPoolServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public SpecialistPoolServiceSettings specialistPoolServiceSettings(
      @Qualifier("defaultSpecialistPoolServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    SpecialistPoolServiceSettings.Builder clientSettingsBuilder =
        SpecialistPoolServiceSettings.newBuilder()
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
          SpecialistPoolServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings createSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSpecialistPoolSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createSpecialistPoolSettings()
          .setRetrySettings(createSpecialistPoolRetrySettings);

      RetrySettings getSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSpecialistPoolSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getSpecialistPoolSettings()
          .setRetrySettings(getSpecialistPoolRetrySettings);

      RetrySettings listSpecialistPoolsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSpecialistPoolsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listSpecialistPoolsSettings()
          .setRetrySettings(listSpecialistPoolsRetrySettings);

      RetrySettings deleteSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSpecialistPoolSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .deleteSpecialistPoolSettings()
          .setRetrySettings(deleteSpecialistPoolRetrySettings);

      RetrySettings updateSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSpecialistPoolSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateSpecialistPoolSettings()
          .setRetrySettings(updateSpecialistPoolRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry createSpecialistPoolRetry = clientProperties.getCreateSpecialistPoolRetry();
    if (createSpecialistPoolRetry != null) {
      RetrySettings createSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSpecialistPoolSettings().getRetrySettings(),
              createSpecialistPoolRetry);
      clientSettingsBuilder
          .createSpecialistPoolSettings()
          .setRetrySettings(createSpecialistPoolRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createSpecialistPool from properties.");
      }
    }
    Retry getSpecialistPoolRetry = clientProperties.getGetSpecialistPoolRetry();
    if (getSpecialistPoolRetry != null) {
      RetrySettings getSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSpecialistPoolSettings().getRetrySettings(),
              getSpecialistPoolRetry);
      clientSettingsBuilder
          .getSpecialistPoolSettings()
          .setRetrySettings(getSpecialistPoolRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getSpecialistPool from properties.");
      }
    }
    Retry listSpecialistPoolsRetry = clientProperties.getListSpecialistPoolsRetry();
    if (listSpecialistPoolsRetry != null) {
      RetrySettings listSpecialistPoolsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSpecialistPoolsSettings().getRetrySettings(),
              listSpecialistPoolsRetry);
      clientSettingsBuilder
          .listSpecialistPoolsSettings()
          .setRetrySettings(listSpecialistPoolsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listSpecialistPools from properties.");
      }
    }
    Retry deleteSpecialistPoolRetry = clientProperties.getDeleteSpecialistPoolRetry();
    if (deleteSpecialistPoolRetry != null) {
      RetrySettings deleteSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSpecialistPoolSettings().getRetrySettings(),
              deleteSpecialistPoolRetry);
      clientSettingsBuilder
          .deleteSpecialistPoolSettings()
          .setRetrySettings(deleteSpecialistPoolRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteSpecialistPool from properties.");
      }
    }
    Retry updateSpecialistPoolRetry = clientProperties.getUpdateSpecialistPoolRetry();
    if (updateSpecialistPoolRetry != null) {
      RetrySettings updateSpecialistPoolRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSpecialistPoolSettings().getRetrySettings(),
              updateSpecialistPoolRetry);
      clientSettingsBuilder
          .updateSpecialistPoolSettings()
          .setRetrySettings(updateSpecialistPoolRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateSpecialistPool from properties.");
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
    Retry setIamPolicyRetry = clientProperties.getSetIamPolicyRetry();
    if (setIamPolicyRetry != null) {
      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), setIamPolicyRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for setIamPolicy from properties.");
      }
    }
    Retry getIamPolicyRetry = clientProperties.getGetIamPolicyRetry();
    if (getIamPolicyRetry != null) {
      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), getIamPolicyRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIamPolicy from properties.");
      }
    }
    Retry testIamPermissionsRetry = clientProperties.getTestIamPermissionsRetry();
    if (testIamPermissionsRetry != null) {
      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(),
              testIamPermissionsRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for testIamPermissions from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public SpecialistPoolServiceClient specialistPoolServiceClient(
      SpecialistPoolServiceSettings specialistPoolServiceSettings) throws IOException {
    return SpecialistPoolServiceClient.create(specialistPoolServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-specialist-pool-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
