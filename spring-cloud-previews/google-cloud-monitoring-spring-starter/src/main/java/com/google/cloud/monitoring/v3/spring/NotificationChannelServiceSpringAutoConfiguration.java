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
import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.cloud.monitoring.v3.NotificationChannelServiceSettings;
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
 * Auto-configuration for {@link NotificationChannelServiceClient}.
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
@ConditionalOnClass(NotificationChannelServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.monitoring.v3.spring.auto.notification-channel-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(NotificationChannelServiceSpringProperties.class)
public class NotificationChannelServiceSpringAutoConfiguration {
  private final NotificationChannelServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(NotificationChannelServiceSpringAutoConfiguration.class);

  protected NotificationChannelServiceSpringAutoConfiguration(
      NotificationChannelServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from NotificationChannelService-specific configuration");
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
  public TransportChannelProvider defaultNotificationChannelServiceTransportChannelProvider() {
    return NotificationChannelServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a NotificationChannelServiceClient bean configured to use the default credentials
   * provider (obtained with notificationChannelServiceCredentials()) and its default transport
   * channel provider (defaultNotificationChannelServiceTransportChannelProvider()). It also
   * configures the quota project ID if provided. It will configure an executor provider in case
   * there is more than one thread configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in NotificationChannelServiceSpringProperties. Method-level properties will take precedence
   * over service-level properties if available, and client library defaults will be used if neither
   * are specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public NotificationChannelServiceSettings notificationChannelServiceSettings(
      @Qualifier("defaultNotificationChannelServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    NotificationChannelServiceSettings.Builder clientSettingsBuilder =
        NotificationChannelServiceSettings.newBuilder()
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
          NotificationChannelServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listNotificationChannelDescriptorsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listNotificationChannelDescriptorsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listNotificationChannelDescriptorsSettings()
          .setRetrySettings(listNotificationChannelDescriptorsRetrySettings);

      RetrySettings getNotificationChannelDescriptorRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getNotificationChannelDescriptorSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getNotificationChannelDescriptorSettings()
          .setRetrySettings(getNotificationChannelDescriptorRetrySettings);

      RetrySettings listNotificationChannelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listNotificationChannelsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listNotificationChannelsSettings()
          .setRetrySettings(listNotificationChannelsRetrySettings);

      RetrySettings getNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getNotificationChannelSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getNotificationChannelSettings()
          .setRetrySettings(getNotificationChannelRetrySettings);

      RetrySettings createNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createNotificationChannelSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createNotificationChannelSettings()
          .setRetrySettings(createNotificationChannelRetrySettings);

      RetrySettings updateNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateNotificationChannelSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateNotificationChannelSettings()
          .setRetrySettings(updateNotificationChannelRetrySettings);

      RetrySettings deleteNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteNotificationChannelSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .deleteNotificationChannelSettings()
          .setRetrySettings(deleteNotificationChannelRetrySettings);

      RetrySettings sendNotificationChannelVerificationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder
                  .sendNotificationChannelVerificationCodeSettings()
                  .getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .sendNotificationChannelVerificationCodeSettings()
          .setRetrySettings(sendNotificationChannelVerificationCodeRetrySettings);

      RetrySettings getNotificationChannelVerificationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder
                  .getNotificationChannelVerificationCodeSettings()
                  .getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getNotificationChannelVerificationCodeSettings()
          .setRetrySettings(getNotificationChannelVerificationCodeRetrySettings);

      RetrySettings verifyNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.verifyNotificationChannelSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .verifyNotificationChannelSettings()
          .setRetrySettings(verifyNotificationChannelRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listNotificationChannelDescriptorsRetry =
        clientProperties.getListNotificationChannelDescriptorsRetry();
    if (listNotificationChannelDescriptorsRetry != null) {
      RetrySettings listNotificationChannelDescriptorsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listNotificationChannelDescriptorsSettings().getRetrySettings(),
              listNotificationChannelDescriptorsRetry);
      clientSettingsBuilder
          .listNotificationChannelDescriptorsSettings()
          .setRetrySettings(listNotificationChannelDescriptorsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listNotificationChannelDescriptors from properties.");
      }
    }
    Retry getNotificationChannelDescriptorRetry =
        clientProperties.getGetNotificationChannelDescriptorRetry();
    if (getNotificationChannelDescriptorRetry != null) {
      RetrySettings getNotificationChannelDescriptorRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getNotificationChannelDescriptorSettings().getRetrySettings(),
              getNotificationChannelDescriptorRetry);
      clientSettingsBuilder
          .getNotificationChannelDescriptorSettings()
          .setRetrySettings(getNotificationChannelDescriptorRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getNotificationChannelDescriptor from properties.");
      }
    }
    Retry listNotificationChannelsRetry = clientProperties.getListNotificationChannelsRetry();
    if (listNotificationChannelsRetry != null) {
      RetrySettings listNotificationChannelsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listNotificationChannelsSettings().getRetrySettings(),
              listNotificationChannelsRetry);
      clientSettingsBuilder
          .listNotificationChannelsSettings()
          .setRetrySettings(listNotificationChannelsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listNotificationChannels from properties.");
      }
    }
    Retry getNotificationChannelRetry = clientProperties.getGetNotificationChannelRetry();
    if (getNotificationChannelRetry != null) {
      RetrySettings getNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getNotificationChannelSettings().getRetrySettings(),
              getNotificationChannelRetry);
      clientSettingsBuilder
          .getNotificationChannelSettings()
          .setRetrySettings(getNotificationChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getNotificationChannel from properties.");
      }
    }
    Retry createNotificationChannelRetry = clientProperties.getCreateNotificationChannelRetry();
    if (createNotificationChannelRetry != null) {
      RetrySettings createNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createNotificationChannelSettings().getRetrySettings(),
              createNotificationChannelRetry);
      clientSettingsBuilder
          .createNotificationChannelSettings()
          .setRetrySettings(createNotificationChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createNotificationChannel from properties.");
      }
    }
    Retry updateNotificationChannelRetry = clientProperties.getUpdateNotificationChannelRetry();
    if (updateNotificationChannelRetry != null) {
      RetrySettings updateNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateNotificationChannelSettings().getRetrySettings(),
              updateNotificationChannelRetry);
      clientSettingsBuilder
          .updateNotificationChannelSettings()
          .setRetrySettings(updateNotificationChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateNotificationChannel from properties.");
      }
    }
    Retry deleteNotificationChannelRetry = clientProperties.getDeleteNotificationChannelRetry();
    if (deleteNotificationChannelRetry != null) {
      RetrySettings deleteNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteNotificationChannelSettings().getRetrySettings(),
              deleteNotificationChannelRetry);
      clientSettingsBuilder
          .deleteNotificationChannelSettings()
          .setRetrySettings(deleteNotificationChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteNotificationChannel from properties.");
      }
    }
    Retry sendNotificationChannelVerificationCodeRetry =
        clientProperties.getSendNotificationChannelVerificationCodeRetry();
    if (sendNotificationChannelVerificationCodeRetry != null) {
      RetrySettings sendNotificationChannelVerificationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder
                  .sendNotificationChannelVerificationCodeSettings()
                  .getRetrySettings(),
              sendNotificationChannelVerificationCodeRetry);
      clientSettingsBuilder
          .sendNotificationChannelVerificationCodeSettings()
          .setRetrySettings(sendNotificationChannelVerificationCodeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for sendNotificationChannelVerificationCode from properties.");
      }
    }
    Retry getNotificationChannelVerificationCodeRetry =
        clientProperties.getGetNotificationChannelVerificationCodeRetry();
    if (getNotificationChannelVerificationCodeRetry != null) {
      RetrySettings getNotificationChannelVerificationCodeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder
                  .getNotificationChannelVerificationCodeSettings()
                  .getRetrySettings(),
              getNotificationChannelVerificationCodeRetry);
      clientSettingsBuilder
          .getNotificationChannelVerificationCodeSettings()
          .setRetrySettings(getNotificationChannelVerificationCodeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getNotificationChannelVerificationCode from properties.");
      }
    }
    Retry verifyNotificationChannelRetry = clientProperties.getVerifyNotificationChannelRetry();
    if (verifyNotificationChannelRetry != null) {
      RetrySettings verifyNotificationChannelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.verifyNotificationChannelSettings().getRetrySettings(),
              verifyNotificationChannelRetry);
      clientSettingsBuilder
          .verifyNotificationChannelSettings()
          .setRetrySettings(verifyNotificationChannelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for verifyNotificationChannel from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public NotificationChannelServiceClient notificationChannelServiceClient(
      NotificationChannelServiceSettings notificationChannelServiceSettings) throws IOException {
    return NotificationChannelServiceClient.create(notificationChannelServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-notification-channel-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
