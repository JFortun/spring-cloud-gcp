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

package com.google.cloud.monitoring.v3.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.cloud.monitoring.v3.AlertPolicyServiceSettings;
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
 * Auto-configuration for {@link AlertPolicyServiceClient}.
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
@ConditionalOnClass(AlertPolicyServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.monitoring.v3.spring.auto.alert-policy-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(AlertPolicyServiceSpringProperties.class)
public class AlertPolicyServiceSpringAutoConfiguration {
  private final AlertPolicyServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(AlertPolicyServiceSpringAutoConfiguration.class);

  protected AlertPolicyServiceSpringAutoConfiguration(
      AlertPolicyServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from AlertPolicyService-specific configuration");
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
  public TransportChannelProvider defaultAlertPolicyServiceTransportChannelProvider() {
    return AlertPolicyServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a AlertPolicyServiceClient bean configured to use the default credentials provider
   * (obtained with alertPolicyServiceCredentials()) and its default transport channel provider
   * (defaultAlertPolicyServiceTransportChannelProvider()). It also configures the quota project ID
   * if provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in AlertPolicyServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public AlertPolicyServiceSettings alertPolicyServiceSettings(
      @Qualifier("defaultAlertPolicyServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    AlertPolicyServiceSettings.Builder clientSettingsBuilder =
        AlertPolicyServiceSettings.newBuilder()
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
          AlertPolicyServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listAlertPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAlertPoliciesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listAlertPoliciesSettings()
          .setRetrySettings(listAlertPoliciesRetrySettings);

      RetrySettings getAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAlertPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getAlertPolicySettings().setRetrySettings(getAlertPolicyRetrySettings);

      RetrySettings createAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createAlertPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createAlertPolicySettings()
          .setRetrySettings(createAlertPolicyRetrySettings);

      RetrySettings deleteAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteAlertPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deleteAlertPolicySettings()
          .setRetrySettings(deleteAlertPolicyRetrySettings);

      RetrySettings updateAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateAlertPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .updateAlertPolicySettings()
          .setRetrySettings(updateAlertPolicyRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listAlertPoliciesRetry = clientProperties.getListAlertPoliciesRetry();
    if (listAlertPoliciesRetry != null) {
      RetrySettings listAlertPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAlertPoliciesSettings().getRetrySettings(),
              listAlertPoliciesRetry);
      clientSettingsBuilder
          .listAlertPoliciesSettings()
          .setRetrySettings(listAlertPoliciesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listAlertPolicies from properties.");
      }
    }
    Retry getAlertPolicyRetry = clientProperties.getGetAlertPolicyRetry();
    if (getAlertPolicyRetry != null) {
      RetrySettings getAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAlertPolicySettings().getRetrySettings(),
              getAlertPolicyRetry);
      clientSettingsBuilder.getAlertPolicySettings().setRetrySettings(getAlertPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getAlertPolicy from properties.");
      }
    }
    Retry createAlertPolicyRetry = clientProperties.getCreateAlertPolicyRetry();
    if (createAlertPolicyRetry != null) {
      RetrySettings createAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createAlertPolicySettings().getRetrySettings(),
              createAlertPolicyRetry);
      clientSettingsBuilder
          .createAlertPolicySettings()
          .setRetrySettings(createAlertPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createAlertPolicy from properties.");
      }
    }
    Retry deleteAlertPolicyRetry = clientProperties.getDeleteAlertPolicyRetry();
    if (deleteAlertPolicyRetry != null) {
      RetrySettings deleteAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteAlertPolicySettings().getRetrySettings(),
              deleteAlertPolicyRetry);
      clientSettingsBuilder
          .deleteAlertPolicySettings()
          .setRetrySettings(deleteAlertPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteAlertPolicy from properties.");
      }
    }
    Retry updateAlertPolicyRetry = clientProperties.getUpdateAlertPolicyRetry();
    if (updateAlertPolicyRetry != null) {
      RetrySettings updateAlertPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateAlertPolicySettings().getRetrySettings(),
              updateAlertPolicyRetry);
      clientSettingsBuilder
          .updateAlertPolicySettings()
          .setRetrySettings(updateAlertPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateAlertPolicy from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public AlertPolicyServiceClient alertPolicyServiceClient(
      AlertPolicyServiceSettings alertPolicyServiceSettings) throws IOException {
    return AlertPolicyServiceClient.create(alertPolicyServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-alert-policy-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
