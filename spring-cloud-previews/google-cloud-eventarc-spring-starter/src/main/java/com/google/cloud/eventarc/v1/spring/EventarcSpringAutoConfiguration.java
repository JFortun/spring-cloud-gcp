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

package com.google.cloud.eventarc.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.eventarc.v1.EventarcClient;
import com.google.cloud.eventarc.v1.EventarcSettings;
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
 * Auto-configuration for {@link EventarcClient}.
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
@ConditionalOnClass(EventarcClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.eventarc.v1.spring.auto.eventarc.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(EventarcSpringProperties.class)
public class EventarcSpringAutoConfiguration {
  private final EventarcSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(EventarcSpringAutoConfiguration.class);

  protected EventarcSpringAutoConfiguration(
      EventarcSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from Eventarc-specific configuration");
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
  public TransportChannelProvider defaultEventarcTransportChannelProvider() {
    return EventarcSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a EventarcClient bean configured to use the default credentials provider (obtained
   * with eventarcCredentials()) and its default transport channel provider
   * (defaultEventarcTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in EventarcSpringProperties. Method-level properties will take precedence over service-level
   * properties if available, and client library defaults will be used if neither are specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public EventarcSettings eventarcSettings(
      @Qualifier("defaultEventarcTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    EventarcSettings.Builder clientSettingsBuilder =
        EventarcSettings.newBuilder()
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
          EventarcSettings.defaultExecutorProviderBuilder()
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
          EventarcSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTriggerSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getTriggerSettings().setRetrySettings(getTriggerRetrySettings);

      RetrySettings listTriggersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTriggersSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listTriggersSettings().setRetrySettings(listTriggersRetrySettings);

      RetrySettings createTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createTriggerSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createTriggerSettings().setRetrySettings(createTriggerRetrySettings);

      RetrySettings updateTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateTriggerSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateTriggerSettings().setRetrySettings(updateTriggerRetrySettings);

      RetrySettings deleteTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteTriggerSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteTriggerSettings().setRetrySettings(deleteTriggerRetrySettings);

      RetrySettings getChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getChannelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getChannelSettings().setRetrySettings(getChannelRetrySettings);

      RetrySettings listChannelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listChannelsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listChannelsSettings().setRetrySettings(listChannelsRetrySettings);

      RetrySettings createChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createChannelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createChannelSettings().setRetrySettings(createChannelRetrySettings);

      RetrySettings updateChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateChannelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateChannelSettings().setRetrySettings(updateChannelRetrySettings);

      RetrySettings deleteChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteChannelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteChannelSettings().setRetrySettings(deleteChannelRetrySettings);

      RetrySettings getProviderRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getProviderSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getProviderSettings().setRetrySettings(getProviderRetrySettings);

      RetrySettings listProvidersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listProvidersSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listProvidersSettings().setRetrySettings(listProvidersRetrySettings);

      RetrySettings getChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getChannelConnectionSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getChannelConnectionSettings()
          .setRetrySettings(getChannelConnectionRetrySettings);

      RetrySettings listChannelConnectionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listChannelConnectionsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listChannelConnectionsSettings()
          .setRetrySettings(listChannelConnectionsRetrySettings);

      RetrySettings createChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createChannelConnectionSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createChannelConnectionSettings()
          .setRetrySettings(createChannelConnectionRetrySettings);

      RetrySettings deleteChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteChannelConnectionSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .deleteChannelConnectionSettings()
          .setRetrySettings(deleteChannelConnectionRetrySettings);

      RetrySettings getGoogleChannelConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGoogleChannelConfigSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getGoogleChannelConfigSettings()
          .setRetrySettings(getGoogleChannelConfigRetrySettings);

      RetrySettings updateGoogleChannelConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateGoogleChannelConfigSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateGoogleChannelConfigSettings()
          .setRetrySettings(updateGoogleChannelConfigRetrySettings);

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
    Retry getTriggerRetry = clientProperties.getGetTriggerRetry();
    if (getTriggerRetry != null) {
      RetrySettings getTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTriggerSettings().getRetrySettings(), getTriggerRetry);
      clientSettingsBuilder.getTriggerSettings().setRetrySettings(getTriggerRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getTrigger from properties.");
      }
    }
    Retry listTriggersRetry = clientProperties.getListTriggersRetry();
    if (listTriggersRetry != null) {
      RetrySettings listTriggersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTriggersSettings().getRetrySettings(), listTriggersRetry);
      clientSettingsBuilder.listTriggersSettings().setRetrySettings(listTriggersRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listTriggers from properties.");
      }
    }
    Retry createTriggerRetry = clientProperties.getCreateTriggerRetry();
    if (createTriggerRetry != null) {
      RetrySettings createTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createTriggerSettings().getRetrySettings(), createTriggerRetry);
      clientSettingsBuilder.createTriggerSettings().setRetrySettings(createTriggerRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createTrigger from properties.");
      }
    }
    Retry updateTriggerRetry = clientProperties.getUpdateTriggerRetry();
    if (updateTriggerRetry != null) {
      RetrySettings updateTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateTriggerSettings().getRetrySettings(), updateTriggerRetry);
      clientSettingsBuilder.updateTriggerSettings().setRetrySettings(updateTriggerRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateTrigger from properties.");
      }
    }
    Retry deleteTriggerRetry = clientProperties.getDeleteTriggerRetry();
    if (deleteTriggerRetry != null) {
      RetrySettings deleteTriggerRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteTriggerSettings().getRetrySettings(), deleteTriggerRetry);
      clientSettingsBuilder.deleteTriggerSettings().setRetrySettings(deleteTriggerRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteTrigger from properties.");
      }
    }
    Retry getChannelRetry = clientProperties.getGetChannelRetry();
    if (getChannelRetry != null) {
      RetrySettings getChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getChannelSettings().getRetrySettings(), getChannelRetry);
      clientSettingsBuilder.getChannelSettings().setRetrySettings(getChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getChannel from properties.");
      }
    }
    Retry listChannelsRetry = clientProperties.getListChannelsRetry();
    if (listChannelsRetry != null) {
      RetrySettings listChannelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listChannelsSettings().getRetrySettings(), listChannelsRetry);
      clientSettingsBuilder.listChannelsSettings().setRetrySettings(listChannelsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listChannels from properties.");
      }
    }
    Retry createChannelRetry = clientProperties.getCreateChannelRetry();
    if (createChannelRetry != null) {
      RetrySettings createChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createChannelSettings().getRetrySettings(), createChannelRetry);
      clientSettingsBuilder.createChannelSettings().setRetrySettings(createChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createChannel from properties.");
      }
    }
    Retry updateChannelRetry = clientProperties.getUpdateChannelRetry();
    if (updateChannelRetry != null) {
      RetrySettings updateChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateChannelSettings().getRetrySettings(), updateChannelRetry);
      clientSettingsBuilder.updateChannelSettings().setRetrySettings(updateChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateChannel from properties.");
      }
    }
    Retry deleteChannelRetry = clientProperties.getDeleteChannelRetry();
    if (deleteChannelRetry != null) {
      RetrySettings deleteChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteChannelSettings().getRetrySettings(), deleteChannelRetry);
      clientSettingsBuilder.deleteChannelSettings().setRetrySettings(deleteChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteChannel from properties.");
      }
    }
    Retry getProviderRetry = clientProperties.getGetProviderRetry();
    if (getProviderRetry != null) {
      RetrySettings getProviderRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getProviderSettings().getRetrySettings(), getProviderRetry);
      clientSettingsBuilder.getProviderSettings().setRetrySettings(getProviderRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getProvider from properties.");
      }
    }
    Retry listProvidersRetry = clientProperties.getListProvidersRetry();
    if (listProvidersRetry != null) {
      RetrySettings listProvidersRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listProvidersSettings().getRetrySettings(), listProvidersRetry);
      clientSettingsBuilder.listProvidersSettings().setRetrySettings(listProvidersRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listProviders from properties.");
      }
    }
    Retry getChannelConnectionRetry = clientProperties.getGetChannelConnectionRetry();
    if (getChannelConnectionRetry != null) {
      RetrySettings getChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getChannelConnectionSettings().getRetrySettings(),
              getChannelConnectionRetry);
      clientSettingsBuilder
          .getChannelConnectionSettings()
          .setRetrySettings(getChannelConnectionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getChannelConnection from properties.");
      }
    }
    Retry listChannelConnectionsRetry = clientProperties.getListChannelConnectionsRetry();
    if (listChannelConnectionsRetry != null) {
      RetrySettings listChannelConnectionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listChannelConnectionsSettings().getRetrySettings(),
              listChannelConnectionsRetry);
      clientSettingsBuilder
          .listChannelConnectionsSettings()
          .setRetrySettings(listChannelConnectionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listChannelConnections from properties.");
      }
    }
    Retry createChannelConnectionRetry = clientProperties.getCreateChannelConnectionRetry();
    if (createChannelConnectionRetry != null) {
      RetrySettings createChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createChannelConnectionSettings().getRetrySettings(),
              createChannelConnectionRetry);
      clientSettingsBuilder
          .createChannelConnectionSettings()
          .setRetrySettings(createChannelConnectionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createChannelConnection from properties.");
      }
    }
    Retry deleteChannelConnectionRetry = clientProperties.getDeleteChannelConnectionRetry();
    if (deleteChannelConnectionRetry != null) {
      RetrySettings deleteChannelConnectionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteChannelConnectionSettings().getRetrySettings(),
              deleteChannelConnectionRetry);
      clientSettingsBuilder
          .deleteChannelConnectionSettings()
          .setRetrySettings(deleteChannelConnectionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteChannelConnection from properties.");
      }
    }
    Retry getGoogleChannelConfigRetry = clientProperties.getGetGoogleChannelConfigRetry();
    if (getGoogleChannelConfigRetry != null) {
      RetrySettings getGoogleChannelConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGoogleChannelConfigSettings().getRetrySettings(),
              getGoogleChannelConfigRetry);
      clientSettingsBuilder
          .getGoogleChannelConfigSettings()
          .setRetrySettings(getGoogleChannelConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getGoogleChannelConfig from properties.");
      }
    }
    Retry updateGoogleChannelConfigRetry = clientProperties.getUpdateGoogleChannelConfigRetry();
    if (updateGoogleChannelConfigRetry != null) {
      RetrySettings updateGoogleChannelConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateGoogleChannelConfigSettings().getRetrySettings(),
              updateGoogleChannelConfigRetry);
      clientSettingsBuilder
          .updateGoogleChannelConfigSettings()
          .setRetrySettings(updateGoogleChannelConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateGoogleChannelConfig from properties.");
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
  public EventarcClient eventarcClient(EventarcSettings eventarcSettings) throws IOException {
    return EventarcClient.create(eventarcSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-eventarc";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
