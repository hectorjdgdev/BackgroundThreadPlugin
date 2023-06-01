#import <Cordova/CDV.h>

@interface BackgroundThreadPlugin : CDVPlugin

- (void)coolMethod:(CDVInvokedUrlCommand*)command;

-(NSString*)publicHelloWorld;


@end
