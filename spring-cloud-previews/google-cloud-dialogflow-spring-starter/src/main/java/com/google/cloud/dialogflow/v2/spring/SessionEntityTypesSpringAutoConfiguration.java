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

package com.google.cloud.dialogflow.v2.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dialogflow.v2.SessionEntityTypesClient;
import com.google.cloud.dialogflow.v2.SessionEntityTypesSettings;
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
 * Auto-configuration for {@link SessionEntityTypesClient}.
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
@ConditionalOnClass(SessionEntityTypesClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dialogflow.v2.spring.auto.session-entity-types.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(SessionEntityTypesSpringProperties.class)
public class SessionEntityTypesSpringAutoConfiguration {
  private final SessionEntityTypesSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(SessionEntityTypesSpringAutoConfiguration.class);

  protected SessionEntityTypesSpringAutoConfiguration(
      SessionEntityTypesSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from SessionEntityTypes-specific configuration");
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
  public TransportChannelProvider defaultSessionEntityTypesTransportChannelProvider() {
    return SessionEntityTypesSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a SessionEntityTypesClient bean configured to use the default credentials provider
   * (obtained with sessionEntityTypesCredentials()) and its default transport channel provider
   * (defaultSessionEntityTypesTransportChannelProvider()). It also configures the quota project ID
   * if provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in SessionEntityTypesSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public SessionEntityTypesSettings sessionEntityTypesSettings(
      @Qualifier("defaultSessionEntityTypesTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    SessionEntityTypesSettings.Builder clientSettingsBuilder =
        SessionEntityTypesSettings.newBuilder()
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
          SessionEntityTypesSettings.defaultExecutorProviderBuilder()
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
          SessionEntityTypesSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings listSessionEntityTypesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSessionEntityTypesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listSessionEntityTypesSettings()
          .setRetrySettings(listSessionEntityTypesRetrySettings);

      RetrySettings getSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSessionEntityTypeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getSessionEntityTypeSettings()
          .setRetrySettings(getSessionEntityTypeRetrySettings);

      RetrySettings createSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSessionEntityTypeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createSessionEntityTypeSettings()
          .setRetrySettings(createSessionEntityTypeRetrySettings);

      RetrySettings updateSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSessionEntityTypeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateSessionEntityTypeSettings()
          .setRetrySettings(updateSessionEntityTypeRetrySettings);

      RetrySettings deleteSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSessionEntityTypeSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .deleteSessionEntityTypeSettings()
          .setRetrySettings(deleteSessionEntityTypeRetrySettings);

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
    Retry listSessionEntityTypesRetry = clientProperties.getListSessionEntityTypesRetry();
    if (listSessionEntityTypesRetry != null) {
      RetrySettings listSessionEntityTypesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSessionEntityTypesSettings().getRetrySettings(),
              listSessionEntityTypesRetry);
      clientSettingsBuilder
          .listSessionEntityTypesSettings()
          .setRetrySettings(listSessionEntityTypesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listSessionEntityTypes from properties.");
      }
    }
    Retry getSessionEntityTypeRetry = clientProperties.getGetSessionEntityTypeRetry();
    if (getSessionEntityTypeRetry != null) {
      RetrySettings getSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSessionEntityTypeSettings().getRetrySettings(),
              getSessionEntityTypeRetry);
      clientSettingsBuilder
          .getSessionEntityTypeSettings()
          .setRetrySettings(getSessionEntityTypeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getSessionEntityType from properties.");
      }
    }
    Retry createSessionEntityTypeRetry = clientProperties.getCreateSessionEntityTypeRetry();
    if (createSessionEntityTypeRetry != null) {
      RetrySettings createSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSessionEntityTypeSettings().getRetrySettings(),
              createSessionEntityTypeRetry);
      clientSettingsBuilder
          .createSessionEntityTypeSettings()
          .setRetrySettings(createSessionEntityTypeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createSessionEntityType from properties.");
      }
    }
    Retry updateSessionEntityTypeRetry = clientProperties.getUpdateSessionEntityTypeRetry();
    if (updateSessionEntityTypeRetry != null) {
      RetrySettings updateSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSessionEntityTypeSettings().getRetrySettings(),
              updateSessionEntityTypeRetry);
      clientSettingsBuilder
          .updateSessionEntityTypeSettings()
          .setRetrySettings(updateSessionEntityTypeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateSessionEntityType from properties.");
      }
    }
    Retry deleteSessionEntityTypeRetry = clientProperties.getDeleteSessionEntityTypeRetry();
    if (deleteSessionEntityTypeRetry != null) {
      RetrySettings deleteSessionEntityTypeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSessionEntityTypeSettings().getRetrySettings(),
              deleteSessionEntityTypeRetry);
      clientSettingsBuilder
          .deleteSessionEntityTypeSettings()
          .setRetrySettings(deleteSessionEntityTypeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteSessionEntityType from properties.");
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
  public SessionEntityTypesClient sessionEntityTypesClient(
      SessionEntityTypesSettings sessionEntityTypesSettings) throws IOException {
    return SessionEntityTypesClient.create(sessionEntityTypesSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-session-entity-types";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
