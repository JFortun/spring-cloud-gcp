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

package com.google.cloud.gsuiteaddons.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient;
import com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsSettings;
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
 * Auto-configuration for {@link GSuiteAddOnsClient}.
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
@ConditionalOnClass(GSuiteAddOnsClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.gsuiteaddons.v1.spring.auto.g-suite-add-ons.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(GSuiteAddOnsSpringProperties.class)
public class GSuiteAddOnsSpringAutoConfiguration {
  private final GSuiteAddOnsSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(GSuiteAddOnsSpringAutoConfiguration.class);

  protected GSuiteAddOnsSpringAutoConfiguration(
      GSuiteAddOnsSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from GSuiteAddOns-specific configuration");
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
  public TransportChannelProvider defaultGSuiteAddOnsTransportChannelProvider() {
    return GSuiteAddOnsSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a GSuiteAddOnsClient bean configured to use the default credentials provider (obtained
   * with gSuiteAddOnsCredentials()) and its default transport channel provider
   * (defaultGSuiteAddOnsTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in GSuiteAddOnsSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public GSuiteAddOnsSettings gSuiteAddOnsSettings(
      @Qualifier("defaultGSuiteAddOnsTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    GSuiteAddOnsSettings.Builder clientSettingsBuilder =
        GSuiteAddOnsSettings.newBuilder()
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
          GSuiteAddOnsSettings.defaultExecutorProviderBuilder()
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
          GSuiteAddOnsSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getAuthorizationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAuthorizationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getAuthorizationSettings()
          .setRetrySettings(getAuthorizationRetrySettings);

      RetrySettings createDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createDeploymentSettings()
          .setRetrySettings(createDeploymentRetrySettings);

      RetrySettings replaceDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.replaceDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .replaceDeploymentSettings()
          .setRetrySettings(replaceDeploymentRetrySettings);

      RetrySettings getDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getDeploymentSettings().setRetrySettings(getDeploymentRetrySettings);

      RetrySettings listDeploymentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDeploymentsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listDeploymentsSettings()
          .setRetrySettings(listDeploymentsRetrySettings);

      RetrySettings deleteDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deleteDeploymentSettings()
          .setRetrySettings(deleteDeploymentRetrySettings);

      RetrySettings installDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.installDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .installDeploymentSettings()
          .setRetrySettings(installDeploymentRetrySettings);

      RetrySettings uninstallDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.uninstallDeploymentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .uninstallDeploymentSettings()
          .setRetrySettings(uninstallDeploymentRetrySettings);

      RetrySettings getInstallStatusRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getInstallStatusSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getInstallStatusSettings()
          .setRetrySettings(getInstallStatusRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getAuthorizationRetry = clientProperties.getGetAuthorizationRetry();
    if (getAuthorizationRetry != null) {
      RetrySettings getAuthorizationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAuthorizationSettings().getRetrySettings(),
              getAuthorizationRetry);
      clientSettingsBuilder
          .getAuthorizationSettings()
          .setRetrySettings(getAuthorizationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getAuthorization from properties.");
      }
    }
    Retry createDeploymentRetry = clientProperties.getCreateDeploymentRetry();
    if (createDeploymentRetry != null) {
      RetrySettings createDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createDeploymentSettings().getRetrySettings(),
              createDeploymentRetry);
      clientSettingsBuilder
          .createDeploymentSettings()
          .setRetrySettings(createDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createDeployment from properties.");
      }
    }
    Retry replaceDeploymentRetry = clientProperties.getReplaceDeploymentRetry();
    if (replaceDeploymentRetry != null) {
      RetrySettings replaceDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.replaceDeploymentSettings().getRetrySettings(),
              replaceDeploymentRetry);
      clientSettingsBuilder
          .replaceDeploymentSettings()
          .setRetrySettings(replaceDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for replaceDeployment from properties.");
      }
    }
    Retry getDeploymentRetry = clientProperties.getGetDeploymentRetry();
    if (getDeploymentRetry != null) {
      RetrySettings getDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getDeploymentSettings().getRetrySettings(), getDeploymentRetry);
      clientSettingsBuilder.getDeploymentSettings().setRetrySettings(getDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getDeployment from properties.");
      }
    }
    Retry listDeploymentsRetry = clientProperties.getListDeploymentsRetry();
    if (listDeploymentsRetry != null) {
      RetrySettings listDeploymentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listDeploymentsSettings().getRetrySettings(),
              listDeploymentsRetry);
      clientSettingsBuilder
          .listDeploymentsSettings()
          .setRetrySettings(listDeploymentsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listDeployments from properties.");
      }
    }
    Retry deleteDeploymentRetry = clientProperties.getDeleteDeploymentRetry();
    if (deleteDeploymentRetry != null) {
      RetrySettings deleteDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteDeploymentSettings().getRetrySettings(),
              deleteDeploymentRetry);
      clientSettingsBuilder
          .deleteDeploymentSettings()
          .setRetrySettings(deleteDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteDeployment from properties.");
      }
    }
    Retry installDeploymentRetry = clientProperties.getInstallDeploymentRetry();
    if (installDeploymentRetry != null) {
      RetrySettings installDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.installDeploymentSettings().getRetrySettings(),
              installDeploymentRetry);
      clientSettingsBuilder
          .installDeploymentSettings()
          .setRetrySettings(installDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for installDeployment from properties.");
      }
    }
    Retry uninstallDeploymentRetry = clientProperties.getUninstallDeploymentRetry();
    if (uninstallDeploymentRetry != null) {
      RetrySettings uninstallDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.uninstallDeploymentSettings().getRetrySettings(),
              uninstallDeploymentRetry);
      clientSettingsBuilder
          .uninstallDeploymentSettings()
          .setRetrySettings(uninstallDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for uninstallDeployment from properties.");
      }
    }
    Retry getInstallStatusRetry = clientProperties.getGetInstallStatusRetry();
    if (getInstallStatusRetry != null) {
      RetrySettings getInstallStatusRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getInstallStatusSettings().getRetrySettings(),
              getInstallStatusRetry);
      clientSettingsBuilder
          .getInstallStatusSettings()
          .setRetrySettings(getInstallStatusRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getInstallStatus from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public GSuiteAddOnsClient gSuiteAddOnsClient(GSuiteAddOnsSettings gSuiteAddOnsSettings)
      throws IOException {
    return GSuiteAddOnsClient.create(gSuiteAddOnsSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-g-suite-add-ons";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
