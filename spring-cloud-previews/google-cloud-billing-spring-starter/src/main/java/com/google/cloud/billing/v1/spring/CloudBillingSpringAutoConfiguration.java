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

package com.google.cloud.billing.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.billing.v1.CloudBillingClient;
import com.google.cloud.billing.v1.CloudBillingSettings;
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
 * Auto-configuration for {@link CloudBillingClient}.
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
@ConditionalOnClass(CloudBillingClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.billing.v1.spring.auto.cloud-billing.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(CloudBillingSpringProperties.class)
public class CloudBillingSpringAutoConfiguration {
  private final CloudBillingSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(CloudBillingSpringAutoConfiguration.class);

  protected CloudBillingSpringAutoConfiguration(
      CloudBillingSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from CloudBilling-specific configuration");
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
  public TransportChannelProvider defaultCloudBillingTransportChannelProvider() {
    return CloudBillingSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a CloudBillingClient bean configured to use the default credentials provider (obtained
   * with cloudBillingCredentials()) and its default transport channel provider
   * (defaultCloudBillingTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in CloudBillingSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public CloudBillingSettings cloudBillingSettings(
      @Qualifier("defaultCloudBillingTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    CloudBillingSettings.Builder clientSettingsBuilder =
        CloudBillingSettings.newBuilder()
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
          CloudBillingSettings.defaultExecutorProviderBuilder()
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
          CloudBillingSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getBillingAccountSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getBillingAccountSettings()
          .setRetrySettings(getBillingAccountRetrySettings);

      RetrySettings listBillingAccountsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listBillingAccountsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listBillingAccountsSettings()
          .setRetrySettings(listBillingAccountsRetrySettings);

      RetrySettings updateBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateBillingAccountSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateBillingAccountSettings()
          .setRetrySettings(updateBillingAccountRetrySettings);

      RetrySettings createBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createBillingAccountSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createBillingAccountSettings()
          .setRetrySettings(createBillingAccountRetrySettings);

      RetrySettings listProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listProjectBillingInfoSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listProjectBillingInfoSettings()
          .setRetrySettings(listProjectBillingInfoRetrySettings);

      RetrySettings getProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getProjectBillingInfoSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getProjectBillingInfoSettings()
          .setRetrySettings(getProjectBillingInfoRetrySettings);

      RetrySettings updateProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateProjectBillingInfoSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .updateProjectBillingInfoSettings()
          .setRetrySettings(updateProjectBillingInfoRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

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
    Retry getBillingAccountRetry = clientProperties.getGetBillingAccountRetry();
    if (getBillingAccountRetry != null) {
      RetrySettings getBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getBillingAccountSettings().getRetrySettings(),
              getBillingAccountRetry);
      clientSettingsBuilder
          .getBillingAccountSettings()
          .setRetrySettings(getBillingAccountRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getBillingAccount from properties.");
      }
    }
    Retry listBillingAccountsRetry = clientProperties.getListBillingAccountsRetry();
    if (listBillingAccountsRetry != null) {
      RetrySettings listBillingAccountsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listBillingAccountsSettings().getRetrySettings(),
              listBillingAccountsRetry);
      clientSettingsBuilder
          .listBillingAccountsSettings()
          .setRetrySettings(listBillingAccountsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listBillingAccounts from properties.");
      }
    }
    Retry updateBillingAccountRetry = clientProperties.getUpdateBillingAccountRetry();
    if (updateBillingAccountRetry != null) {
      RetrySettings updateBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateBillingAccountSettings().getRetrySettings(),
              updateBillingAccountRetry);
      clientSettingsBuilder
          .updateBillingAccountSettings()
          .setRetrySettings(updateBillingAccountRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateBillingAccount from properties.");
      }
    }
    Retry createBillingAccountRetry = clientProperties.getCreateBillingAccountRetry();
    if (createBillingAccountRetry != null) {
      RetrySettings createBillingAccountRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createBillingAccountSettings().getRetrySettings(),
              createBillingAccountRetry);
      clientSettingsBuilder
          .createBillingAccountSettings()
          .setRetrySettings(createBillingAccountRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createBillingAccount from properties.");
      }
    }
    Retry listProjectBillingInfoRetry = clientProperties.getListProjectBillingInfoRetry();
    if (listProjectBillingInfoRetry != null) {
      RetrySettings listProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listProjectBillingInfoSettings().getRetrySettings(),
              listProjectBillingInfoRetry);
      clientSettingsBuilder
          .listProjectBillingInfoSettings()
          .setRetrySettings(listProjectBillingInfoRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listProjectBillingInfo from properties.");
      }
    }
    Retry getProjectBillingInfoRetry = clientProperties.getGetProjectBillingInfoRetry();
    if (getProjectBillingInfoRetry != null) {
      RetrySettings getProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getProjectBillingInfoSettings().getRetrySettings(),
              getProjectBillingInfoRetry);
      clientSettingsBuilder
          .getProjectBillingInfoSettings()
          .setRetrySettings(getProjectBillingInfoRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getProjectBillingInfo from properties.");
      }
    }
    Retry updateProjectBillingInfoRetry = clientProperties.getUpdateProjectBillingInfoRetry();
    if (updateProjectBillingInfoRetry != null) {
      RetrySettings updateProjectBillingInfoRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateProjectBillingInfoSettings().getRetrySettings(),
              updateProjectBillingInfoRetry);
      clientSettingsBuilder
          .updateProjectBillingInfoSettings()
          .setRetrySettings(updateProjectBillingInfoRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateProjectBillingInfo from properties.");
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
  public CloudBillingClient cloudBillingClient(CloudBillingSettings cloudBillingSettings)
      throws IOException {
    return CloudBillingClient.create(cloudBillingSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-cloud-billing";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
